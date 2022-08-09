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
    Checkout createCheckout(@RequestBody Checkout checkout){
        return checkoutService.addCheckout(checkout);
    }

    @GetMapping("/{checkoutID}")
    Checkout readCheckout(@PathVariable String checkoutID){
        return checkoutService.getCheckout(checkoutID);
    }

    @PutMapping
    Checkout updateCheckout(@RequestBody Checkout checkout){
        return checkoutService.updateCheckout(checkout);
    }

    @DeleteMapping("/{checkoutID}")
    String deleteCheckout(@PathVariable String checkoutID){
        return checkoutService.deleteCheckout(checkoutID);
    }

}
