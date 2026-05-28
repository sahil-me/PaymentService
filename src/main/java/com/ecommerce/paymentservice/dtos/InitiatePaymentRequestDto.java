package com.ecommerce.paymentservice.dtos;

import com.ecommerce.paymentservice.enums.PaymentGatewayType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {

    private Long orderId;
    private Long amount;
    private String phoneNumber;
    private String name;
    private String email;
    private PaymentGatewayType gatewayName;

}
