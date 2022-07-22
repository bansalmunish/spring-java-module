package com.example.controller;

import com.example.audit.AuditLog;
import com.example.audit.logger.controller.PaymentEnquiryControllerAuditLogger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class PaymentEnquiryController {

    @GetMapping("/enquiry/{txnId}")
    @AuditLog(auditClass = PaymentEnquiryControllerAuditLogger.class)
    public String enquiry(@PathVariable String txnId){

        return "payment for " + txnId + " is failed :P";
    }

}
