package com.payments.service;

import com.payments.methods.PaymentMethod;
import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;
import com.payments.registry.PaymentRegistry;

public class PaymentService {
    private PaymentRegistry registry;

    public PaymentService(PaymentRegistry registry) {
        this.registry = registry;
    }

    public PaymentResult completePayment(String methodName, PaymentRequest request) {
        PaymentMethod method = registry.getMethod(methodName);
        return method.pay(request);
    }
}
