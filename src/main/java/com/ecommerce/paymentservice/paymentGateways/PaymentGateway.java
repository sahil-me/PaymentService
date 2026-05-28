package com.ecommerce.paymentservice.paymentGateways;

import com.ecommerce.paymentservice.exceptions.PaymentGatewayException;

public interface PaymentGateway {

    String generatePaymentLink(Long order_id, Long amount, String phoneNumber, String name, String email) throws PaymentGatewayException;
}
