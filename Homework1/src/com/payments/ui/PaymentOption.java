package com.payments.ui;

public class PaymentOption {
    private final String label;
    private final String className;

    public PaymentOption(String label, String className) {
        this.label = label;
        this.className = className;
    }

    public String getLabel() {
        return label;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return label;
    }
}