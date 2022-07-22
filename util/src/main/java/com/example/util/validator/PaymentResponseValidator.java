package com.example.util.validator;

import com.example.commons.PaymentResponse;
import com.example.util.AssertionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentResponseValidator implements Validator<PaymentResponse> {

    @Override
    public void validate(PaymentResponse paymentResponse) {
        AssertionUtil.assertNotNullOrEmpty(paymentResponse.getHtml());
        log.info("payment response validated successfully");
    }
}
