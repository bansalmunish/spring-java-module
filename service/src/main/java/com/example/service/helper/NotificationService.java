package com.example.service.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class NotificationService {

    @Async
    public void sendSms(){
        log.info("sending notification async...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Exception",e);
        }
        log.info("notification sent...");
    }
}

