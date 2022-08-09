package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@AllArgsConstructor
@Data
public class Insurer {
    @Indexed(unique = true)
    private String name;
    private Integer premium;
}
