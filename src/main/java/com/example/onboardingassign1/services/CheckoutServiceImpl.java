package com.example.onboardingassign1.services;

import com.example.onboardingassign1.models.Checkout;
import com.example.onboardingassign1.models.Insurer;
import com.example.onboardingassign1.models.VPRequest;
import com.example.onboardingassign1.models.VehicleInsurers;
import com.example.onboardingassign1.repositories.CheckoutRepository;
import com.example.onboardingassign1.repositories.VPRequestRepository;
import com.example.onboardingassign1.repositories.VehicleInsurersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    @Autowired
    private CheckoutRepository checkoutRepo;

    @Autowired
    private VPRequestRepository vpRequestRepository;

    @Autowired
    private VehicleInsurersRepository vehicleInsurersRepository;

    @Override
    public Checkout addCheckout(Checkout checkout) {
        Optional<VPRequest> vpRequest=vpRequestRepository.findById(checkout.getRequestID());
        if(vpRequest.isPresent()){
            Checkout checkout1=checkoutRepo.save(checkout);
            return checkout1;
        }
        return null;
    }

    @Override
    public Checkout getCheckout(String checkoutID) {
        Optional<Checkout> checkout=checkoutRepo.findById(checkoutID);
        if(checkout.isPresent()){
            return checkout.get();
        }
        return null;
    }

    @Override
    public Checkout updateCheckout(Checkout checkout) {
        Optional<Checkout> existingCheckout=checkoutRepo.findById(checkout.getCheckoutID());
        Optional<VPRequest> vpRequest=vpRequestRepository.findById(checkout.getRequestID());
        if(existingCheckout.isPresent() && vpRequest.isPresent()){
            return checkoutRepo.save(checkout);
        }
        return null;
    }

    @Override
    public String deleteCheckout(String checkoutID) {
        Optional<Checkout> checkout=checkoutRepo.findById(checkoutID);
        if (checkout.isPresent()){
            checkoutRepo.delete(checkout.get());
            return "Deletion Successful !!";
        }
        return "Deletion Failed !!";
    }
}
