package com.example.service.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PaymentGateway {

    @Async
    public void doSomeAsync(){
        log.info("doing something async...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Exception",e);
        }
        log.info("async done...");
    }
}

