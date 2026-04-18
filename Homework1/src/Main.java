package com.payments;

import com.payments.methods.CreditCardPayment;
import com.payments.methods.PaypalPayment;
import com.payments.methods.PaymentMethod;
import com.payments.registry.PaymentRegistry;
import com.payments.service.PaymentService;
import com.payments.ui.PaymentFrame;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod paypal = new PaypalPayment();

        Map<String, PaymentMethod> methods = new HashMap<>();
        methods.put(creditCard.getName(), creditCard);
        methods.put(paypal.getName(), paypal);

        PaymentRegistry registry = new PaymentRegistry(methods);
        PaymentService paymentService = new PaymentService(registry);

        new PaymentFrame(paymentService);
    }
}