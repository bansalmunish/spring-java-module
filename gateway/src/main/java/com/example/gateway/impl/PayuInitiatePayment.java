package com.example.gateway.impl;

import com.example.audit.AuditLog;
import com.example.audit.logger.gateway.InitiatePaymentGatewayAuditLogger;
import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;
import com.example.commons.enums.ErrorType;
import com.example.commons.enums.PaymentStatus;
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
//            Thread.sleep((long) (Math.random()*1000));
            paymentResponse.setStatus(Math.random()>0.7? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
            if(PaymentStatus.FAILED == paymentResponse.getStatus()){
                paymentResponse.setErrorType(Math.random()>0.7 ? ErrorType.BD : ErrorType.TD);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return paymentResponse;
    }
}
