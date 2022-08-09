package com.example.onboardingassign1.controllers;

import com.example.onboardingassign1.models.Checkout;
import com.example.onboardingassign1.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    @PostMapping
    String createCheckout(@RequestBody Checkout checkout){
        return checkoutService.addCheckout(checkout);
    }

    @GetMapping("/{checkoutID}")
    Checkout readCheckout(@PathVariable String checkoutID){
        return checkoutService.getCheckout(checkoutID);
    }

}
