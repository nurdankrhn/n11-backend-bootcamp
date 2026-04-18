package com.payments.model;

import java.util.HashMap;
import java.util.Map;

public class PaymentRequest {
    private double amount;
    private String customerName;
    private Map<String, String> details;

    public PaymentRequest(double amount, String customerName) {
        this.amount = amount;
        this.customerName = customerName;
        this.details = new HashMap<>();
    }

    public PaymentRequest(double amount, String customerName, Map<String, String> details) {
        this.amount = amount;
        this.customerName = customerName;
        this.details = details;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Map<String, String> getDetails() {
        return details;
    }
}