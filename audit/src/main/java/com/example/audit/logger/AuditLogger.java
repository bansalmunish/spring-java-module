package com.example.audit.logger;

public interface AuditLogger {

    void log(String methodName, Object[] args, Object value, Exception e, long executionTime);
}
