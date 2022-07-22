package com.example.gateway.impl;

import com.example.audit.AuditLog;
import com.example.audit.logger.gateway.InitiatePaymentAuditLogger;
import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;
import com.example.gateway.InitiatePayment;
import org.springframework.stereotype.Service;

@Service
public class PayuInitiatePayment implements InitiatePayment {

    @Override
    @AuditLog(auditClass = InitiatePaymentAuditLogger.class)
    public PaymentResponse getHtml(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setHtml("this is the payu html for amount " + paymentRequest.getAmount());
        return paymentResponse;
    }
}
