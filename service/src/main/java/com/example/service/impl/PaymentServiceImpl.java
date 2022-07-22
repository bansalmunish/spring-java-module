package com.example.service.impl;

import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;
import com.example.gateway.InitiatePayment;
import com.example.service.PaymentService;
import com.example.service.helper.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final NotificationService notificationService;
    private final InitiatePayment initiatePayment;

    @Override
    public PaymentResponse initiatePayment(PaymentRequest paymentRequest) {
        log.info("payment request received....");
        notificationService.sendSms();
        var paymentResponse = initiatePayment.getHtml(paymentRequest);
        log.info("returning payment response....");
        return paymentResponse;
    }

}
