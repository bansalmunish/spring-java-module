package com.example.util.validator;

import com.example.commons.PaymentRequest;
import com.example.util.AssertionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentRequestValidator implements Validator<PaymentRequest> {

    @Override
    public void validate(PaymentRequest paymentRequest) {
        AssertionUtil.assertGreaterThanZero(paymentRequest.getAmount());
        log.info("payment request validated successfully");
    }
}
