package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.repositories.VPRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VPRequestServiceImpl implements VPRequestService {
    @Autowired
    private VPRequestRepository vpRequestRepo;

    @Override
    public String addVehicleProfileRequest(VPRequest vpRequest){
        VPRequest request=vpRequestRepo.save(vpRequest);
        return request.getRequestID();
    }

    @Override
    public VPRequest getVehicleProfileRequest(String requestID) {
        return null;
    }

    @Override
    public VPRequest updateVehicleProfileRequest(VPRequest vpRequest) {
        return null;
    }

    @Override
    public String deleteVehicleProfileRequest(String requestID) {
        return null;
    }
}