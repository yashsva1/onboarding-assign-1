package com.example.onboardingassign1.repositories;

import com.example.onboardingassign1.models.VehicleInsurers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInsurersRepository extends MongoRepository<VehicleInsurers,String> {
    VehicleInsurers findOneByMakeAndModel(String make,String model);
}
