package com.example.audit.logger.controller;

import com.example.audit.logger.AuditLogger;
import com.example.commons.error.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class PaymentEnquiryAuditLogger implements AuditLogger {

    @Override
    public void log(String methodName, Object[] args, Object value, CustomException e, long executionTime) {
        log.info("logging method : {}", methodName);
        Arrays.stream(args)
                .forEach(o -> log.info("arg value: {}", o.toString()));
        log.info("logging value : {}", value);
    }
}
