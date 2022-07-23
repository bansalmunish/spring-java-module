package com.example.commons;

import com.example.commons.enums.ErrorType;
import com.example.commons.enums.PaymentStatus;
import lombok.Data;

@Data
public class PaymentResponse {

    private PaymentStatus status;
    private ErrorType errorType;
    private String html;

}
