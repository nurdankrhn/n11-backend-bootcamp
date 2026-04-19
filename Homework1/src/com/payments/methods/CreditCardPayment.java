package com.payments.methods;

import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public PaymentResult pay(PaymentRequest request) {
        String message = "Payment completed successfully with Credit Card. Customer: "
                + request.getCustomerName() + ", Amount: " + request.getAmount();
        return new PaymentResult(true, message);
    }
}