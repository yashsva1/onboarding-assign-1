package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.models.VehicleInsurers;
import com.example.onboardingassign1.repositories.VPRequestRepository;
import com.example.onboardingassign1.repositories.VehicleInsurersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleInsurersServiceImpl implements VehicleInsurersService{

    @Autowired
    VehicleInsurersRepository vehicleInsurersRepo;
    @Autowired
    VPRequestRepository vpRequestRepo;

    @Override
    public VehicleInsurers getAllAvailableInsurers(String requestID) {
        Optional<VPRequest> vpRequest=vpRequestRepo.findById(requestID);
        if(vpRequest.isPresent()){
            VehicleInsurers vehicleInsurers= vehicleInsurersRepo.findOneByMakeAndModel(vpRequest.get().getVehicleMake(),vpRequest.get().getVehicleModel());
            return vehicleInsurers;
        }
        return null;
    }
}
