package com.example.onboardingassign1.controllers;

import com.example.onboardingassign1.models.VehicleInsurers;
import com.example.onboardingassign1.services.VehicleInsurersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurers")
public class VehicleInsurersController {

    @Autowired
    VehicleInsurersService vehicleInsurersService;

    @GetMapping("/{requestID}")
    public VehicleInsurers getAllAvailableInsurers(@PathVariable String requestID){
        return vehicleInsurersService.getAllAvailableInsurers(requestID);
    }
}
