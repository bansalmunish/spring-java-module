package com.example.service.impl;

import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;
import com.example.service.PaymentService;
import com.example.service.gateway.PaymentGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentGateway paymentGateway;

    @Override
    public PaymentResponse initiatePayment(PaymentRequest paymentRequest) {
        log.info("payment request received....");
        paymentGateway.doSomeAsync();
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setHtml("this is the test html for amount " + paymentRequest.getAmount());
        log.info("returning payment response....");
        return paymentResponse;
    }

}
