package com.example.onboardingassign1.services;

import com.example.onboardingassign1.errorHandling.ResourceNotFoundException;
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
        if (!vpRequest.isPresent()) throw new ResourceNotFoundException(" Invalid requestID | ");

        Checkout checkout1=checkoutRepo.save(checkout);
        return checkout1;
    }

    @Override
    public Checkout getCheckout(String checkoutID) {
        Optional<Checkout> checkout=checkoutRepo.findById(checkoutID);
        if (!checkout.isPresent()) throw new ResourceNotFoundException(" Invalid checkoutID |");
        return checkout.get();
    }

    @Override
    public Checkout updateCheckout(Checkout checkout) {
        Optional<String> checkoutIDOpt=Optional.ofNullable(checkout.getCheckoutID());
        if(!checkoutIDOpt.isPresent()) throw new ResourceNotFoundException("checkoutID field missing | ");

        Optional<Checkout> existingCheckout=checkoutRepo.findById(checkout.getCheckoutID());
        if (!existingCheckout.isPresent()) throw new ResourceNotFoundException(" Invalid checkoutID | ");

        Optional<VPRequest> vpRequest=vpRequestRepository.findById(checkout.getRequestID());
        if (!vpRequest.isPresent()) throw new ResourceNotFoundException(" Invalid requestID | ");

        return checkoutRepo.save(checkout);
    }

    @Override
    public String deleteCheckout(String checkoutID) {
        Optional<Checkout> checkout=checkoutRepo.findById(checkoutID);
        if (!checkout.isPresent()) throw new ResourceNotFoundException(" Invalid checkoutID | ");
        checkoutRepo.delete(checkout.get());
        return "Deletion Successful !!";
    }
}
