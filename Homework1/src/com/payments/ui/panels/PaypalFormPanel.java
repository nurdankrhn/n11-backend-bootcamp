package com.payments.ui.panels;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PaypalFormPanel extends JPanel implements PaymentFormPanel {
    private final JTextField emailField = new JTextField(20);

    public PaypalFormPanel() {
        setLayout(new GridLayout(1, 2));
        add(new JLabel("PayPal Email:"));
        add(emailField);
    }

    public Map<String, String> getFormData() {
        Map<String, String> data = new HashMap<>();
        data.put("email", emailField.getText());
        return data;
    }
}