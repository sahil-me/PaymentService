package com.ecommerce.paymentservice.paymentGateways;

import com.ecommerce.paymentservice.exceptions.PaymentGatewayException;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway {

    RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(Long order_id, Long amount, String phoneNumber, String name, String email) throws PaymentGatewayException {

        // Initialize Client

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount);
        paymentLinkRequest.put("currency","INR");

//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);

        paymentLinkRequest.put(
                "expire_by",
                (System.currentTimeMillis() / 1000) + (20 * 60)
        );
        paymentLinkRequest.put("reference_id", order_id.toString());
        paymentLinkRequest.put("description", "Payment for buying biscuits");

        JSONObject customer = new JSONObject();
        customer.put("name", name);
        customer.put("contact",phoneNumber);
        customer.put("email", email);

        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        paymentLinkRequest.put("reminder_enable",true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);

        paymentLinkRequest.put("callback_url","https://scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        try {

            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

            return payment.get("short_url").toString();

        } catch (RazorpayException e) {

            throw new PaymentGatewayException(
                    "Failed to generate Razorpay payment link",
                    e
            );
        }

    }

}
