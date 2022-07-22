package com.example.util.validator;

import com.example.commons.PaymentResponse;
import com.example.commons.error.CustomErrorCode;
import com.example.commons.error.CustomException;
import com.example.util.AssertionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentResponseValidator implements Validator<PaymentResponse> {

    @Override
    public void validate(PaymentResponse paymentResponse) {
        AssertionUtil.assertNotNullOrEmpty(paymentResponse.getHtml(), new CustomException(CustomErrorCode.UNABLE_TO_GENERATE_PAYMENT_HTML));
        log.info("payment response validated successfully");
    }
}
