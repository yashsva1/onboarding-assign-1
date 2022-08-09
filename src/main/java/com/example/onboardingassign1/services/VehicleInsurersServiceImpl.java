package com.example.onboardingassign1.services;

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
        if(vpRequest.isPresent()){
            VehicleInsurers vehicleInsurers= vehicleInsurersRepo.findOneByMakeAndModel(vpRequest.get().getVehicleMake(),vpRequest.get().getVehicleModel());
            return vehicleInsurers;
        }
        return null;
    }

    @Override
    public String addVehicleInsurers(VehicleInsurers vehicleInsurers) {
        VehicleInsurers vehicleInsurers1=vehicleInsurersRepo.save(vehicleInsurers);
        return vehicleInsurers1.getID();
    }

    @Override
    public VehicleInsurers getVehicleInsurers(String id) {
        Optional<VehicleInsurers> vehicleInsurers=vehicleInsurersRepo.findById(id);
        if(vehicleInsurers.isPresent()){
            return vehicleInsurers.get();
        }
        return null;
    }

    @Override
    public VehicleInsurers updateVehicleInsurers(VehicleInsurers vehicleInsurers) {
        Optional<VehicleInsurers> existingVehicleInsurers=vehicleInsurersRepo.findById(vehicleInsurers.getID());
        if(existingVehicleInsurers.isPresent()){
            return vehicleInsurersRepo.save(vehicleInsurers);
        }
        return null;
    }

    @Override
    public String deleteVehicleInsurers(String requestID) {
        Optional<VehicleInsurers> vehicleInsurers=vehicleInsurersRepo.findById(requestID);
        if (vehicleInsurers.isPresent()){
            vehicleInsurersRepo.delete(vehicleInsurers.get());
            return "Deletion Successful !!";
        }
        return "Deletion Failed !!";
    }
}
