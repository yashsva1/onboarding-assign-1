package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.models.VehicleInsurers;
import com.example.onboardingassign1.repositories.VPRequestRepository;
import com.example.onboardingassign1.repositories.VehicleInsurersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VPRequestServiceImpl implements VPRequestService {
    @Autowired
    private VPRequestRepository vpRequestRepo;

    @Autowired
    private VehicleInsurersRepository vehicleInsurersRepo;

    @Override
    public String addVehicleProfileRequest(VPRequest vpRequest){
        Optional<VehicleInsurers> vehicleInsurers= vehicleInsurersRepo.findOneByMakeAndModel(vpRequest.getVehicleMake(),vpRequest.getVehicleModel());
        if (vehicleInsurers.isPresent())
            vpRequest.setAvailableInsurers(vehicleInsurers.get().getSupportedInsurers());
        VPRequest request=vpRequestRepo.save(vpRequest);
        return request.getRequestID();
    }

    @Override
    public VPRequest getVehicleProfileRequest(String requestID) {
        VPRequest request=vpRequestRepo.findById(requestID).get();
        return request;
    }

    @Override
    public VPRequest updateVehicleProfileRequest(VPRequest vpRequest) {
        Optional<VPRequest> existingVPRequest=vpRequestRepo.findById(vpRequest.getRequestID());
        if(existingVPRequest.isPresent()){
            Optional<VehicleInsurers> vehicleInsurers= vehicleInsurersRepo.findOneByMakeAndModel(vpRequest.getVehicleMake(),vpRequest.getVehicleModel());
            if (vehicleInsurers.isPresent())
                vpRequest.setAvailableInsurers(vehicleInsurers.get().getSupportedInsurers());

            return vpRequestRepo.save(vpRequest);
        }
        return null;
    }

    @Override
    public String deleteVehicleProfileRequest(String requestID) {
        Optional<VPRequest> vpRequest=vpRequestRepo.findById(requestID);
        if(vpRequest.isPresent()){
            vpRequestRepo.delete(vpRequest.get());
            return "Deletion Successful";
        }

        return "Deletion Failed";
    }
}
