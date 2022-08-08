package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.VPRequest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface VPRequestService {
    String addVehicleProfileRequest(VPRequest VPRequest);

    VPRequest getVehicleProfileRequest(String requestID);

    VPRequest updateVehicleProfileRequest(VPRequest VPRequest);

    String deleteVehicleProfileRequest(String requestID);


}
