package com.example.onboardingassign1.controllers;

import com.example.onboardingassign1.models.VehicleInsurers;
import com.example.onboardingassign1.services.VehicleInsurersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/insurers")
public class VehicleInsurersController {

    @Autowired
    VehicleInsurersService vehicleInsurersService;

    @GetMapping("/available-insurers/{requestID}")
    public VehicleInsurers getAllAvailableInsurers(@PathVariable @NotBlank String requestID){
        return vehicleInsurersService.getAllAvailableInsurers(requestID);
    }

    @PostMapping
    public String createVehicleInsurers(@RequestBody @Valid VehicleInsurers vehicleInsurers){
        return vehicleInsurersService.addVehicleInsurers(vehicleInsurers);
    }

    @GetMapping("/{id}")
    public VehicleInsurers getVehicleInsurers(@PathVariable @NotBlank String id){
        return vehicleInsurersService.getVehicleInsurers(id);
    }

    @PutMapping
    public VehicleInsurers updateVehicleInsurers(@RequestBody @Valid VehicleInsurers vehicleInsurers){
        return vehicleInsurersService.updateVehicleInsurers(vehicleInsurers);
    }

    @DeleteMapping("/{id}")
    public String deleteVehicleInsurers(@PathVariable @NotBlank String id){
        return vehicleInsurersService.deleteVehicleInsurers(id);
    }
}
