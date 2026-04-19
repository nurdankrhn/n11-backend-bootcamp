package com.payments;

import com.payments.factory.PaymentFactory;
import com.payments.service.PaymentService;
import com.payments.ui.PaymentFrame;

public class Main {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new PaymentFactory();
        PaymentService paymentService = new PaymentService(paymentFactory);

        new PaymentFrame(paymentService);
    }
}