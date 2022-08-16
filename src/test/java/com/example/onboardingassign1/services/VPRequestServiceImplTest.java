package com.example.onboardingassign1.services;

import com.example.onboardingassign1.repositories.VPRequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class VPRequestServiceImplTest {

    @Autowired
    private VPRequestService vpRequestService;

    @MockBean
    private VPRequestRepository vpRequestRepository;

    @Test
    void addVehicleProfileRequest() {
    }

    @Test
    void getVehicleProfileRequest() {
    }

    @Test
    void updateVehicleProfileRequest() {
    }

    @Test
    void deleteVehicleProfileRequest() {
    }
}