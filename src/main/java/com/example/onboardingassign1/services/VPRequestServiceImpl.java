package com.example.onboardingassign1.services;

import com.example.onboardingassign1.errorHandling.ResourceNotFoundException;
import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.models.VehicleInsurers;
import com.example.onboardingassign1.repositories.VPRequestRepository;
import com.example.onboardingassign1.repositories.VehicleInsurersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

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
        if(!vehicleInsurers.isPresent()) throw new ResourceNotFoundException(" No vehicle insurers available for the given vehicleMake and vehicleModel | ");

        vpRequest.setAvailableInsurers(vehicleInsurers.get().getSupportedInsurers());
        VPRequest request = vpRequestRepo.save(vpRequest);

        return request.getRequestID();
    }

    @Override
    public VPRequest getVehicleProfileRequest(String requestID) {
        Optional<VPRequest> request=vpRequestRepo.findById(requestID);
        if(!request.isPresent()) throw new ResourceNotFoundException(" Invalid requestID | ");
        return request.get();
    }

    @Override
    public VPRequest updateVehicleProfileRequest(VPRequest vpRequest) {
        Optional<String> requestIDOpt= Optional.ofNullable(vpRequest.getRequestID());
        if(!requestIDOpt.isPresent()) throw new ResourceNotFoundException("requestID field Missing |");

        Optional<VPRequest> existingVPRequest=vpRequestRepo.findById(vpRequest.getRequestID());
        if(!existingVPRequest.isPresent()) throw new ResourceNotFoundException("Update failed  - Invalid requestID | ");

        Optional<VehicleInsurers> vehicleInsurers = vehicleInsurersRepo.findOneByMakeAndModel(vpRequest.getVehicleMake(), vpRequest.getVehicleModel());
        if(!vehicleInsurers.isPresent()) throw new ResourceNotFoundException("Update failed  - No vehicle insurers available for the given vertical, vehicleMake and vehicleModel | ");

        vpRequest.setAvailableInsurers(vehicleInsurers.get().getSupportedInsurers());

        return vpRequestRepo.save(vpRequest);
    }

    @Override
    public String deleteVehicleProfileRequest(String requestID) {
        Optional<VPRequest> vpRequest=vpRequestRepo.findById(requestID);
        if(!vpRequest.isPresent()) throw new ResourceNotFoundException(" Deletion failed - Invalid requestID | ");

        vpRequestRepo.delete(vpRequest.get());

        return "Deletion Successful";

    }
}
