package com.example.gateway;

import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;

public interface InitiatePayment {

    PaymentResponse getHtml(PaymentRequest paymentRequest);
}
