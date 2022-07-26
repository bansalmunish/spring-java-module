package com.example.controller;

import com.example.audit.AuditLog;
import com.example.audit.logger.controller.InitiatePaymentControllerAuditLogger;
import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;
import com.example.commons.web.ApiResponse;
import com.example.commons.web.Meta;
import com.example.service.PaymentService;
import com.example.util.Validators;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class InitiatePaymentController {

    private final Validators validators;
    private final PaymentService paymentService;

    @PostMapping("/payment")
    @AuditLog(auditClass = InitiatePaymentControllerAuditLogger.class)
    public ApiResponse<PaymentResponse> get(@RequestBody PaymentRequest paymentRequest){

        validators.validate(paymentRequest);
        var paymentResponse = paymentService.initiatePayment(paymentRequest);
        validators.validate(paymentResponse);

        var meta = new Meta();
        meta.setSuccess(true);
        var apiResponse = new ApiResponse<PaymentResponse>();
        apiResponse.setMeta(meta);
        apiResponse.setData(paymentResponse);

        return apiResponse;
    }

}
