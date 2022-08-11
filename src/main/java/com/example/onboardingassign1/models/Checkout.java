package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Document(collection = "checkouts")
public class Checkout {
    @Id
    private String checkoutID;
    @NotBlank(message = "name cannot be empty")
    private String name;
    @Email(message = "Invalid email", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotBlank(message = "email cannot be empty")
    private String email;
    @Pattern(regexp="[\\d]{10}",message = "Invalid phone")
    @NotBlank(message = "phone cannot be empty")
    private String phone;
    @NotBlank(message = "requestID cannot be empty")
    private String requestID;
    @NotBlank(message = "insurer cannot be empty")
    private String insurer;

}
