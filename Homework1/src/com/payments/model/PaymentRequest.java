package com.payments.model;

public class PaymentRequest {
    private double amount;
    private String customerName;

    public PaymentRequest(double amount, String customerName) {
        this.amount = amount;
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }
}