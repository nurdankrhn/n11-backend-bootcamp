package com.payments.methods;

import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;

public class PaypalPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "paypal";
    }

    @Override
    public PaymentResult pay(PaymentRequest request) {
        return new  PaymentResult(true, "Successful payment with a PayPal");
    }
}
