package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "vehicle_insurers")
public class VehicleInsurers {
    private String make;
    private String model;
    private List<Insurer> supportedInsurers;
}
