package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@Data
public class Insurer {
    @Indexed(unique = true)
    @NotBlank(message = "name cannot be empty")
    private String name;
    @NotNull(message = "premium cannot be empty")
    @Positive(message = "premium should be positive")
    private Integer premium;
}
