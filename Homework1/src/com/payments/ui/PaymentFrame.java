package com.payments.ui;

import com.payments.model.PaymentRequest;
import com.payments.model.PaymentResult;
import com.payments.service.PaymentService;
import com.payments.ui.panels.CreditCardFormPanel;
import com.payments.ui.panels.PaymentFormPanel;
import com.payments.ui.panels.PaypalFormPanel;

import javax.swing.*;
import java.awt.*;

public class PaymentFrame extends JFrame {

    private final PaymentService paymentService;

    private final JTextField customerNameField = new JTextField(15);
    private final JTextField amountField = new JTextField(15);

    private final JComboBox<PaymentOption> methodBox = new JComboBox<>(
            new PaymentOption[]{
                    new PaymentOption("Credit Card", "CreditCardPayment"),
                    new PaymentOption("PayPal", "PaypalPayment")
            }
    );

    private final JPanel dynamicPanel = new JPanel(new BorderLayout());
    private final JLabel resultLabel = new JLabel("Result will be shown here");

    private PaymentFormPanel currentFormPanel;

    public PaymentFrame(PaymentService paymentService) {
        this.paymentService = paymentService;

        setTitle("Payment Screen");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Customer Name:"));
        add(customerNameField);

        add(new JLabel("Amount:"));
        add(amountField);

        add(new JLabel("Payment Method:"));
        add(methodBox);

        add(new JLabel("Method Details:"));
        add(dynamicPanel);

        JButton payButton = new JButton("Pay");
        add(payButton);
        add(resultLabel);

        updateFormPanel();

        methodBox.addActionListener(e -> updateFormPanel());
        payButton.addActionListener(e -> makePayment());

        setVisible(true);
    }

    private void updateFormPanel() {
        dynamicPanel.removeAll();

        PaymentOption selectedOption = (PaymentOption) methodBox.getSelectedItem();
        if (selectedOption == null) return;

        String className = selectedOption.getClassName();

        if ("CreditCardPayment".equals(className)) {
            currentFormPanel = new CreditCardFormPanel();
        } else if ("PaypalPayment".equals(className)) {
            currentFormPanel = new PaypalFormPanel();
        } else {
            currentFormPanel = null;
        }

        if (currentFormPanel != null) {
            dynamicPanel.add((JPanel) currentFormPanel, BorderLayout.CENTER);
        }

        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }

    private void makePayment() {
        try {
            String customerName = customerNameField.getText();
            double amount = Double.parseDouble(amountField.getText());

            PaymentOption selectedOption = (PaymentOption) methodBox.getSelectedItem();
            if (selectedOption == null) {
                resultLabel.setText("Error: No payment method selected.");
                return;
            }

            PaymentRequest request = new PaymentRequest(amount, customerName);
            PaymentResult result = paymentService.completePayment(selectedOption.getClassName(), request);

            resultLabel.setText(result.getMessage());
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }
}