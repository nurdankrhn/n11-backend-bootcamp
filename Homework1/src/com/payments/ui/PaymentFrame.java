package com.payments.ui;

import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;
import com.payments.service.PaymentService;
import com.payments.ui.panels.CreditCardFormPanel;
import com.payments.ui.panels.PaymentFormPanel;
import com.payments.ui.panels.PaypalFormPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PaymentFrame extends JFrame {
    private final PaymentService paymentService;
    private final JTextField customerNameField = new JTextField(15);
    private final JTextField amountField = new JTextField(15);
    private final JComboBox<String> methodBox = new JComboBox<>(new String[]{"creditCard", "paypal"});
    private final JPanel dynamicPanel = new JPanel(new BorderLayout());
    private final JLabel resultLabel = new JLabel("Result will be shown here");
    private PaymentFormPanel currentFormPanel;

    public PaymentFrame(PaymentService paymentService) {
        this.paymentService = paymentService;

        setTitle("Payment Screen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Customer Name:")); add(customerNameField);
        add(new JLabel("Amount:")); add(amountField);
        add(new JLabel("Payment Method:")); add(methodBox);
        add(new JLabel("Method Details:")); add(dynamicPanel);

        JButton payButton = new JButton("Pay");
        add(payButton); add(resultLabel);

        updateFormPanel();
        methodBox.addActionListener(e -> updateFormPanel());
        payButton.addActionListener(e -> makePayment());

        setVisible(true);
    }

    private void updateFormPanel() {
        dynamicPanel.removeAll();
        String selected = (String) methodBox.getSelectedItem();

        if ("creditCard".equals(selected)) {
            currentFormPanel = new CreditCardFormPanel();
        } else {
            currentFormPanel = new PaypalFormPanel();
        }

        dynamicPanel.add((JPanel) currentFormPanel, BorderLayout.CENTER);
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }

    private void makePayment() {
        try {
            String customerName = customerNameField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String method = (String) methodBox.getSelectedItem();
            Map<String, String> details = currentFormPanel.getFormData();

            PaymentRequest request = new PaymentRequest(amount, customerName, details);
            PaymentResult result = paymentService.completePayment(method, request);

            resultLabel.setText(result.getMessage());
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }
}