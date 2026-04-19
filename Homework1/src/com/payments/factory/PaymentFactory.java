package com.payments.factory;

import com.payments.methods.PaymentMethod;

public class PaymentFactory {

    private static final String BASE_PACKAGE = "com.payments.methods.";

    public PaymentMethod create(String className) {
        try {
            Class<?> c = Class.forName(BASE_PACKAGE + className);
            Object instance = c.getDeclaredConstructor().newInstance();

            if (!(instance instanceof PaymentMethod)) {
                throw new IllegalArgumentException(className + " does not implement PaymentMethod.");
            }

            return (PaymentMethod) instance;
        } catch (Exception e) {
            throw new RuntimeException("Payment method could not be created: " + className, e);
        }
    }
}