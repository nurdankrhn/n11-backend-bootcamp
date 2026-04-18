package com.payments.methods;

import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;

public interface PaymentMethod {
    String getName();
    PaymentResult pay(PaymentRequest request);
}
