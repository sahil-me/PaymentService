package com.ecommerce.paymentservice.paymentGateways;

import com.ecommerce.paymentservice.exceptions.PaymentGatewayException;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink(Long order_id, Long amount, String phoneNumber, String name, String email) throws PaymentGatewayException {

        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl("https://scaler.com/")
                        .setCancelUrl("https://scaler.com/")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(1L)
                                        .setPriceData(
                                                SessionCreateParams.LineItem.PriceData.builder()
                                                        .setCurrency("inr")
                                                        .setUnitAmount(amount)
                                                        .setProductData(
                                                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                        .setName("Order Payment")
                                                                        .build()
                                                        )
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        try {

            Session session = Session.create(params);

            return session.getUrl();

        } catch (StripeException e) {

            throw new PaymentGatewayException(
                    "Failed to generate Stripe payment link",
                    e
            );
        }

    }
}
