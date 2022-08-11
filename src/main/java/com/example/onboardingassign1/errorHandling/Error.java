package com.example.onboardingassign1.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Error {
    private String message;
    private int status;
    private Long timestamp;

}
