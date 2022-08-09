package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.Checkout;
import com.example.onboardingassign1.repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public Checkout updateCheckout(Checkout checkout) {
        return null;
    }

    @Override
    public String deleteCheckout(String requestID) {
        return null;
    }
}
