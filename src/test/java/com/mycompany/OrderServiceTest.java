package com.mycompany;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    public OrderServiceTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createOrder method, of class OrderService.
     */
    @Test
    public void testCreateOrder() {
        // Crear un mock de PaymentService
        PaymentService mockPaymentService = mock(PaymentService.class);

        // Crear la instancia de OrderService, pasando el mock de PaymentService
        OrderService orderService = new OrderService(mockPaymentService);

        // Llamar al método createOrder
        orderService.createOrder(100.0);

        // Verificar que el método processPayment fue llamado con el argumento correcto (100.0)
        verify(mockPaymentService, times(1)).processPayment(100.0);

        // Verificar que el método processPayment devuelve true
        when(mockPaymentService.processPayment(100.0)).thenReturn(true);
        // Aseguramos que se procesa correctamente el pago
        assertTrue(orderService.createOrder(100.0)); 
    }

    @Test
    public void testCreateOrder_FailureOnPayment() {
        // Crear un mock de PaymentService
        PaymentService mockPaymentService = mock(PaymentService.class);

        // Configurar el mock para que devuelva false cuando se procese el pago
        when(mockPaymentService.processPayment(100.0)).thenReturn(false);

        // Crear la instancia de OrderService, pasando el mock de PaymentService
        OrderService orderService = new OrderService(mockPaymentService);

        // Llamar al método createOrder y verificar que devuelve false debido a que el pago falló
        assertFalse(orderService.createOrder(100.0));
    }
}
