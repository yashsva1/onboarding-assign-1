package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.Checkout;
import com.example.onboardingassign1.repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    @Autowired
    private CheckoutRepository checkoutRepo;

    @Override
    public String addCheckout(Checkout checkout) {
        Checkout checkout1=checkoutRepo.save(checkout);
        return checkout1.getCheckoutID();
    }

    @Override
    public Checkout getCheckout(String requestID) {
        Optional<Checkout> checkout=checkoutRepo.findById(requestID);
        if(checkout.isPresent()){
            return checkout.get();
        }
        return null;
    }

    @Override
    public Checkout updateCheckout(Checkout checkout) {
        Optional<Checkout> existingCheckout=checkoutRepo.findById(checkout.getCheckoutID());
        if(existingCheckout.isPresent()){
            return checkoutRepo.save(checkout);
        }
        return null;
    }

    @Override
    public String deleteCheckout(String requestID) {
        Optional<Checkout> checkout=checkoutRepo.findById(requestID);
        if (checkout.isPresent()){
            checkoutRepo.delete(checkout.get());
            return "Deletion Successful !!";
        }
        return "Deletion Failed !!";
    }
}
