# Payment System - New Payment Method Integration with SOLID Principles

## Assignment Description
This project was developed for the assignment **“New Payment Method Integration (with SOLID Principles)”**.

In this scenario, an existing payment screen already contains payment methods, and a **new payment method** must be integrated into the system without breaking the current structure.

The implementation focuses on designing the backend in a way that is extensible, maintainable, and aligned with **SOLID** and **OOP** principles.

---

## Expectations
The following requirements were considered during development:

- Preserve the existing code structure as much as possible
- Integrate the new payment method according to SOLID principles
- Especially focus on:
    - **Open/Closed Principle (OCP):** extend the system without modifying the main business flow
    - **Single Responsibility Principle (SRP):** each class should have a single responsibility
- Keep the codebase open for future payment method integrations

---

## Technical Scope
The application includes a simple payment flow with:

- **Existing payment method:** Credit Card
- **New payment method:** PayPal

The project also includes a lightweight **Java Swing UI** to demonstrate the payment flow visually.

---

## Project Structure

- `PaymentMethod` → common contract for all payment methods
- `CreditCardPayment` → existing payment method
- `PaypalPayment` → newly added payment method
- `PaymentFactory` → creates payment method objects dynamically using **Reflection**
- `PaymentService` → manages the payment flow
- `PaymentFrame` → simple Swing-based UI
- `PaymentRequest` / `PaymentResult` → request and response models

---

## Design Approach

Instead of hardcoding payment method creation in the service layer, the project uses a **Factory** structure with **Reflection**.

The user selects the payment method from the UI, and the backend sends the selected class name to `PaymentFactory`.  
`PaymentFactory` then creates the related payment method object dynamically.

This allows the system to support new payment methods without changing the core payment flow.

---

## Why Reflection?
Reflection is used in `PaymentFactory` to create payment method objects dynamically based on the selected payment method.

This means the backend does not need to directly instantiate concrete classes such as:

- `new CreditCardPayment()`
- `new PaypalPayment()`

Instead, the system creates the correct object at runtime according to the payment method selected from the UI.

---

## SOLID Principles Applied

### 1. Open/Closed Principle (OCP)
The system is open for extension but closed for modification.

To add a new payment method:
- create a new class implementing `PaymentMethod`
- make it selectable from the UI

The main payment flow does not need to change.

### 2. Single Responsibility Principle (SRP)
Each class has only one responsibility:

- `PaymentFactory` → creates payment method objects
- `PaymentService` → executes the payment process
- `PaymentFrame` → handles UI interactions
- payment method classes → implement their own payment behavior

### 3. Dependency Inversion Principle (DIP)
`PaymentService` works with the `PaymentMethod` abstraction instead of depending directly on concrete payment classes.

---

## Application Flow

1. The user opens the payment screen
2. The user enters customer name and amount
3. The user selects a payment method from the UI
4. The UI sends the selected payment method information to the backend
5. `PaymentService` calls `PaymentFactory`
6. `PaymentFactory` creates the related payment class using Reflection
7. The selected payment method completes the payment
8. The result is shown on the screen

---

## How to Run

1. Open the project in IntelliJ IDEA
2. Run `Main.java`
3. Enter the required payment information
4. Select a payment method
5. Click the **Pay** button

---

## Example Payment Methods
Currently implemented:

- Credit Card
- PayPal

This structure can easily be extended with new payment methods such as:

- Apple Pay
- Google Pay
- Crypto Payment

---

## Screenshots

### Payment Options
![Payment options](./images/paymentOptions.png)

### Credit Card Payment
![Payment via credit card](./images/payWithCreditCard.png)

### PayPal Payment
![Payment via PayPal](./images/payWithPaypal.png)

---

## Notes
This is a basic educational project prepared to demonstrate how a new payment method can be integrated into an existing payment system by following **SOLID** and **OOP** principles in Java.