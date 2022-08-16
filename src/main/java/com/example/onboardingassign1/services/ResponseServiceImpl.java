package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.Response;
import com.example.onboardingassign1.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepo;

    @Override
    public void createResponses(List<Response> responses) {
        responseRepo.saveAll(responses);
    }

    @Override
    public void deleteAllByRequestID(String requestID) {
        responseRepo.deleteAllByRequestID(requestID);
    }


}
