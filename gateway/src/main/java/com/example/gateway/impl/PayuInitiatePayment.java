package com.example.gateway.impl;

import com.example.audit.AuditLog;
import com.example.audit.logger.gateway.InitiatePaymentGatewayAuditLogger;
import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;
import com.example.gateway.InitiatePayment;
import org.springframework.stereotype.Service;

@Service
public class PayuInitiatePayment implements InitiatePayment {

    @Override
    @AuditLog(auditClass = InitiatePaymentGatewayAuditLogger.class)
    public PaymentResponse getHtml(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setHtml("this is the payu html for amount " + paymentRequest.getAmount());

        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return paymentResponse;
    }
}
