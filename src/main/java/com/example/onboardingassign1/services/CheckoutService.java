package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.Checkout;
import com.example.onboardingassign1.models.VPRequest;

public interface CheckoutService {
    Checkout addCheckout(Checkout checkout);

    Checkout getCheckout(String requestID);

    Checkout updateCheckout(Checkout checkout);

    String deleteCheckout(String requestID);
}
