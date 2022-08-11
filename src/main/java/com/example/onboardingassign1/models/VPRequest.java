package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "vehicle_profile_requests")
public class VPRequest {

    @Id
    private String requestID;
    @NotBlank(message = "Vertical cannot be empty")
    private String vertical;
    @NotBlank(message = "VehicleMake cannot be empty")
    private String vehicleMake;
    @NotBlank(message = "VehicleModel cannot be empty")
    private String vehicleModel;
    private List<Insurer> availableInsurers= new ArrayList<>();


}
