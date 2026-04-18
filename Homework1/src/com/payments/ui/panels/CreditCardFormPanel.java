package com.payments.ui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CreditCardFormPanel extends JPanel implements PaymentFormPanel {
    private final JTextField cardNumberField = new JTextField(15);
    private final JTextField cvvField = new JTextField(5);

    public CreditCardFormPanel() {
        setLayout(new GridLayout(2, 2));
        add(new JLabel("Card Number:"));
        add(cardNumberField);
        add(new JLabel("CVV:"));
        add(cvvField);
    }

    public Map<String, String> getFormData() {
        Map<String, String> data = new HashMap<>();
        data.put("cardNumber", cardNumberField.getText());
        data.put("cvv", cvvField.getText());
        return data;
    }
}
