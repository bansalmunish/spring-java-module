package com.example.audit.logger.controller;

import com.example.audit.logger.AuditLogger;
import com.example.commons.PaymentRequest;
import com.example.commons.PaymentResponse;
import com.example.commons.enums.ErrorType;
import com.example.commons.enums.PaymentStatus;
import com.example.commons.error.CustomException;
import com.example.commons.web.ApiResponse;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class InitiatePaymentControllerAuditLogger implements AuditLogger {

    private MeterRegistry meterRegistry;
    private Counter paymentFailureBDCounter;
    private Counter paymentFailureTDCounter;
    private Counter paymentSuccessCounter;
    private Counter paymentAttempt;
    private Timer paymentTimer;

    public InitiatePaymentControllerAuditLogger(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        paymentFailureBDCounter = this.meterRegistry.counter("payment.failure.bd");
        paymentFailureTDCounter = this.meterRegistry.counter("payment.failure.td");
        paymentSuccessCounter = this.meterRegistry.counter("payment.success");
        paymentAttempt = this.meterRegistry.counter("payment.attempt");
        paymentTimer = this.meterRegistry.timer("payment.timer");
    }

    @Override
    public void log(String methodName, Object[] args, Object value, CustomException e, long executionTime) {
        log.info("logging method : {}", methodName);

        PaymentRequest paymentRequest = (PaymentRequest) args[0];
        PaymentResponse paymentResponse = ((ApiResponse<PaymentResponse>) value).getData();


        paymentAttempt.increment();
        if(PaymentStatus.SUCCESS == paymentResponse.getStatus()){
            paymentSuccessCounter.increment();
        }else if (paymentResponse.getStatus() == PaymentStatus.FAILED) {
            if (ErrorType.TD == paymentResponse.getErrorType()) {
                paymentFailureTDCounter.increment();
            } else {
                paymentFailureBDCounter.increment();
            }
        }

        paymentFailureBDCounter.increment(paymentRequest.getAmount());
        paymentTimer.record(executionTime, TimeUnit.MILLISECONDS);

        Arrays.stream(args)
                .forEach(o -> log.info("arg value: {}", o.toString()));
        log.info("logging value : {}", value);

        if (e != null)
            log.error("Exception occurred : {}", e.getCustomErrorCode());
    }
}
