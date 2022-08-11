package com.example.onboardingassign1.services;

import com.example.onboardingassign1.errorHandling.ResourceNotFoundException;
import com.example.onboardingassign1.models.Checkout;
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
        if(!vpRequest.isPresent()) throw new ResourceNotFoundException(" Invalid requestID ");

        Optional<VehicleInsurers> vehicleInsurers= vehicleInsurersRepo.findOneByMakeAndModel(vpRequest.get().getVehicleMake(),vpRequest.get().getVehicleModel());
        if(!vehicleInsurers.isPresent()) throw new ResourceNotFoundException("  No vehicle insurers available for the given vertical, make and model | ");

        vpRequest.get().setAvailableInsurers(vehicleInsurers.get().getSupportedInsurers());
        vpRequestRepo.save(vpRequest.get());

        return vehicleInsurers.get();
    }

    @Override
    public String addVehicleInsurers(VehicleInsurers vehicleInsurers) {
        Optional<VehicleInsurers> existingRecordForSameData=vehicleInsurersRepo.findOneByMakeAndModel(vehicleInsurers.getMake(),vehicleInsurers.getModel());
        if(existingRecordForSameData.isPresent()) throw new ResourceNotFoundException(" Vehicle insurers already exists for the given vertical, make and model | ");

        VehicleInsurers vehicleInsurers1=vehicleInsurersRepo.save(vehicleInsurers);
        return vehicleInsurers1.getID();
    }

    @Override
    public VehicleInsurers getVehicleInsurers(String id) {
        Optional<VehicleInsurers> vehicleInsurers=vehicleInsurersRepo.findById(id);
        if(!vehicleInsurers.isPresent()) throw new ResourceNotFoundException(" Invalid record ID");

        return vehicleInsurers.get();
    }

    @Override
    public VehicleInsurers updateVehicleInsurers(VehicleInsurers vehicleInsurers) {
        Optional<String> idOpt=Optional.ofNullable(vehicleInsurers.getID());
        if(!idOpt.isPresent()) throw new ResourceNotFoundException(" id field missing | ");

        Optional<VehicleInsurers> existingVehicleInsurers=vehicleInsurersRepo.findById(vehicleInsurers.getID());
        if(!existingVehicleInsurers.isPresent()) throw new ResourceNotFoundException(" Invalid record ID");

        Optional<VehicleInsurers> existingRecordForSameData=vehicleInsurersRepo.findOneByMakeAndModel(vehicleInsurers.getMake(),vehicleInsurers.getModel());
        if(existingRecordForSameData.isPresent()) throw new ResourceNotFoundException(" Vehicle insurers already exists for the given vertical, make and model | ");

        return vehicleInsurersRepo.save(vehicleInsurers);
    }

    @Override
    public String deleteVehicleInsurers(String requestID) {
        Optional<VehicleInsurers> vehicleInsurers=vehicleInsurersRepo.findById(requestID);
        if(!vehicleInsurers.isPresent()) throw new ResourceNotFoundException(" Invalid record ID");

        vehicleInsurersRepo.delete(vehicleInsurers.get());
        return "Deletion Successful !!";
    }
}
