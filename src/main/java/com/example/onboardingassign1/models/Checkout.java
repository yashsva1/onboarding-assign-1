package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "checkouts")
public class Checkout {
    @Id
    private String checkoutID;
    private String name;
    private String email;
    private String phone;
    private String requestID;
    private String insurer;

}
