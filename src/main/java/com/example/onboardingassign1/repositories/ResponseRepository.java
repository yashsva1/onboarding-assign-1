package com.example.onboardingassign1.repositories;

import com.example.onboardingassign1.models.Response;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponseRepository extends MongoRepository<Response,String> {
    void deleteAllByRequestID(String requestID);

    Optional<Response> findOneByRequestIDAndResultID(String requestID, String resultID);
}
