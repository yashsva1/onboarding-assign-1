package com.example.onboardingassign1.controllers;

import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.services.VPRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/vehicle-profile")
public class VehicleProfileController {

    @Autowired
    private VPRequestService vpRequestService;

    @PostMapping
    public String createVehicleProfileRequest(@RequestBody @Valid VPRequest VPRequest){
        return vpRequestService.addVehicleProfileRequest(VPRequest);
    }

    @GetMapping("/{requestID}")
    public ResponseEntity<VPRequest> getVehicleProfileRequest(@PathVariable @NotBlank String requestID){
        return  ResponseEntity.ok(vpRequestService.getVehicleProfileRequest(requestID));
    }

    @PutMapping
    public  ResponseEntity<VPRequest> updateVehicleProfileRequest(@RequestBody @Valid VPRequest vpRequest){
        return ResponseEntity.ok(vpRequestService.updateVehicleProfileRequest(vpRequest));
    }

    @DeleteMapping("/{requestID}")
    public String deleteVehicleProfileRequest(@PathVariable @NotBlank String requestID){
        return vpRequestService.deleteVehicleProfileRequest(requestID);
    }

}
