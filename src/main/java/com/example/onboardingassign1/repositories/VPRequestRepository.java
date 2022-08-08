package com.example.onboardingassign1.repositories;

import com.example.onboardingassign1.models.VPRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VPRequestRepository extends MongoRepository<VPRequest,String> {
}
