package com.example.commons.error;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum CustomErrorCode {

    AMOUNT_IS_LESS_THAN_0(1, "amount can't be less than or equal to 0", HttpStatus.BAD_REQUEST),

    UNABLE_TO_GENERATE_PAYMENT_HTML(101, "unable to generate the payment html", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}
