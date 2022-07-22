package com.example.audit.aspect;

import com.example.audit.AuditLog;
import com.example.audit.logger.AuditLogger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class PaymentControllerAspect {

    private final ApplicationContext applicationContext;

    @Around("@annotation(com.example.audit.AuditLog)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info("{} executed in {} ms", joinPoint.getSignature() , executionTime);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        callActualLogger(joinPoint, proceed, null, executionTime);
        return proceed;
    }

    @AfterThrowing(value = "@annotation(com.example.audit.AuditLog)", throwing = "e")
    public void myAdvice(JoinPoint joinPoint, Exception e){
        log.info("EXCEPTION CAUGHT");
        callActualLogger(joinPoint, null, e, 0);
        Thread.setDefaultUncaughtExceptionHandler((t, e1) -> log.info("Caught " + e1.getMessage()));
    }

    private void callActualLogger(JoinPoint joinPoint, Object response, Exception e, long executionTime) {

        //https://www.baeldung.com/spring-aop-get-advised-method-info

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AuditLog auditLog = method.getAnnotation(AuditLog.class);
        AuditLogger auditLogger = applicationContext.getBean(auditLog.auditClass());
        auditLogger.log(methodSignature.getMethod().getName(), joinPoint.getArgs(), response, e, executionTime);
    }

}
