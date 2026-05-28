package com.ecommerce.paymentservice.services;

import com.ecommerce.paymentservice.enums.PaymentGatewayType;
import com.ecommerce.paymentservice.exceptions.PaymentGatewayException;
import com.ecommerce.paymentservice.paymentGateways.PaymentGateway;
import com.ecommerce.paymentservice.paymentGateways.PaymentGatewayFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewayFactory paymentGatewayFactory;

    public PaymentService(
            PaymentGatewayFactory paymentGatewayFactory
    ) {

        this.paymentGatewayFactory = paymentGatewayFactory;
    }

    public String initiatePayment(
            Long order_id,
            Long amount,
            String phoneNumber,
            String name,
            String email,
            PaymentGatewayType gatewayType
    ) throws PaymentGatewayException {

        PaymentGateway paymentGateway =
                paymentGatewayFactory.getPaymentGateway(gatewayType);

        return paymentGateway.generatePaymentLink(
                order_id,
                amount,
                phoneNumber,
                name,
                email
        );
    }
}
