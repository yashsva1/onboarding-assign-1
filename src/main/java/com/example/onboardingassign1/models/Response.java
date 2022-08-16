package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@Document("responses")
public class Response {
    @Id
    String resultID;
    @NotBlank(message = "requestID cannot be empty")
    String requestID;
    @NotBlank(message = "insurer cannot be empty")
    String insurer;
    @NotNull(message = "premium cannot be empty")
    @Positive(message = "premium should be positive")
    Integer premium;

}
