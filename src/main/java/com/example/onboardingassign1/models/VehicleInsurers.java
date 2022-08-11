package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "vehicle_insurers")
@CompoundIndex(def = "{ 'vertical' : 1, 'make' : 1, 'model' : 1 }",unique = true)
public class VehicleInsurers {
    @Id
    private String ID;
    @NotBlank(message = "vertical cannot be empty")
    private String vertical;
    @NotBlank(message = "make cannot be empty")
    private String make;
    @NotBlank(message = "model cannot be empty")
    private String model;
    @NotEmpty
    private List< @Valid Insurer> supportedInsurers;
}
