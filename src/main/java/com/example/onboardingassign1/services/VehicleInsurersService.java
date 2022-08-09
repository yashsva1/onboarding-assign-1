package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.Checkout;
import com.example.onboardingassign1.models.VehicleInsurers;
import org.springframework.stereotype.Service;

public interface VehicleInsurersService {
    VehicleInsurers getAllAvailableInsurers(String requestID);

    String addVehicleInsurers(VehicleInsurers vehicleInsurers);

    VehicleInsurers getVehicleInsurers(String id);

    VehicleInsurers updateVehicleInsurers(VehicleInsurers vehicleInsurers);

    String deleteVehicleInsurers(String requestID);
}
