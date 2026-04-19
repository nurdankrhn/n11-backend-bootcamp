package com.payments.service;

import com.payments.factory.PaymentFactory;
import com.payments.methods.PaymentMethod;
import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;

public class PaymentService {

    private final PaymentFactory paymentFactory;

    public PaymentService(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    public PaymentResult completePayment(String paymentMethodClassName, PaymentRequest request) {
        try {
            PaymentMethod paymentMethod = paymentFactory.create(paymentMethodClassName);
            return paymentMethod.pay(request);
        } catch (Exception e) {
            return new PaymentResult(false, "Payment failed: " + e.getMessage());
        }
    }
}