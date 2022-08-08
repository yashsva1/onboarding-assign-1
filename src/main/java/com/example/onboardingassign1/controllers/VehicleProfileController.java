package com.example.onboardingassign1.controllers;

import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.services.VPRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle-profile")
public class VehicleProfileController {

    @Autowired
    private VPRequestService vpRequestService;

    @PostMapping()
    public String createVehicleProfileRequest(@RequestBody VPRequest VPRequest){
        return vpRequestService.addVehicleProfileRequest(VPRequest);
    }

}
