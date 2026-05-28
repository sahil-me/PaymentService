package com.ecommerce.paymentservice.controllers;

import com.ecommerce.paymentservice.dtos.InitiatePaymentRequestDto;
import com.ecommerce.paymentservice.exceptions.PaymentGatewayException;
import com.ecommerce.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws PaymentGatewayException {

        return paymentService.initiatePayment(
                initiatePaymentRequestDto.getOrderId(),
                initiatePaymentRequestDto.getAmount(),
                initiatePaymentRequestDto.getPhoneNumber(),
                initiatePaymentRequestDto.getName(),
                initiatePaymentRequestDto.getEmail(),
                initiatePaymentRequestDto.getGatewayName());
    }

    @PostMapping("/webhook")
    public void triggerWebhook(){

        System.out.println("Webhook Triggered");
    }

}
