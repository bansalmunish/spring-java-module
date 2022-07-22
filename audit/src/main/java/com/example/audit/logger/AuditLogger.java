package com.example.audit.logger;

import com.example.commons.error.CustomException;

public interface AuditLogger {

    void log(String methodName, Object[] args, Object value, CustomException e, long executionTime);
}
