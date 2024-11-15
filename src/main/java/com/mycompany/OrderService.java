package com.mycompany;

// Clase que maneja el proceso de creación de pedidos
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Método que realiza un pedido, llamando al servicio de pagos
    public boolean createOrder(double amount) {
        // Lógica para crear un pedido
        // Procesa el pago
        return paymentService.processPayment(amount);
    }
}
