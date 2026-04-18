package com.payments.registry;

import com.payments.methods.PaymentMethod;

import java.util.Map;

public class PaymentRegistry {
    private Map<String, PaymentMethod> methods;

    public PaymentRegistry(Map<String, PaymentMethod> methods) {
        this.methods = methods;
    }

    public PaymentMethod getMethod(String methodName) {
        return methods.get(methodName);
    }
}
