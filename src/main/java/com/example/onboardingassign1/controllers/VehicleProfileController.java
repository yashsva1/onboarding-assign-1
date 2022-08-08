package com.example.onboardingassign1.controllers;

import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.services.VPRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle-profile")
public class VehicleProfileController {

    @Autowired
    private VPRequestService vpRequestService;

    @PostMapping()
    public String createVehicleProfileRequest(@RequestBody VPRequest VPRequest){
        return vpRequestService.addVehicleProfileRequest(VPRequest);
    }

    @GetMapping("/{requestID}")
    public ResponseEntity<VPRequest> getVehicleProfileRequest(@PathVariable String requestID){
        return  ResponseEntity.ok(vpRequestService.getVehicleProfileRequest(requestID));

    }

    @PutMapping
    public  ResponseEntity<VPRequest> updateVehicleProfileRequest(@RequestBody VPRequest vpRequest){
        return ResponseEntity.ok(vpRequestService.updateVehicleProfileRequest(vpRequest));
    }

}
