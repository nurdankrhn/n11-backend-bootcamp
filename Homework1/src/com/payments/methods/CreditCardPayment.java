package com.payments.methods;

import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "creditCard";
    }

    @Override
    public PaymentResult pay(PaymentRequest request) {
        return new  PaymentResult(true, "Successful payment with a Credit Card");
    }
}
