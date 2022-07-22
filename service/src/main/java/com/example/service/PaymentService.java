package com.example.service;

import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;

public interface PaymentService {

    PaymentResponse initiatePayment(PaymentRequest paymentRequest);
}
