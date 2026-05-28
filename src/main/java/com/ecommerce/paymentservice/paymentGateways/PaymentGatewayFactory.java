package com.ecommerce.paymentservice.paymentGateways;

import com.ecommerce.paymentservice.enums.PaymentGatewayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayFactory {

    @Autowired
    private RazorpayPaymentGateway razorpayPaymentGateway;

    @Autowired
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGateway getPaymentGateway(PaymentGatewayType gatewayType) {

        if(gatewayType == PaymentGatewayType.RAZORPAY) {
            return razorpayPaymentGateway;
        }

        if(gatewayType == PaymentGatewayType.STRIPE) {
            return stripePaymentGateway;
        }

        throw new RuntimeException("Unsupported Payment Gateway");

    }

}
