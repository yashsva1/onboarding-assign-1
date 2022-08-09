package com.example.onboardingassign1.repositories;

import com.example.onboardingassign1.models.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends MongoRepository<Checkout,String> {
}
