package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "vehicle_insurers")
@CompoundIndex(def = "{ 'vertical' : 1, 'make' : 1, 'model' : 1 }",unique = true)
public class VehicleInsurers {
    @Id
    private String ID;
    private String vertical;
    private String make;
    private String model;
    private List<Insurer> supportedInsurers;
}
