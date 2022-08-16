package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.Response;

import java.util.List;

public interface ResponseService {

    void createResponses(List<Response> responses);

    void deleteAllByRequestID(String requestID);

}
