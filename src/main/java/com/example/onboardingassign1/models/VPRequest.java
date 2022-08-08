package com.example.onboardingassign1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@Data
@Document(collection = "vehicle_profile_requests")
public class VPRequest {

    @Id
    private String requestID;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;


}
