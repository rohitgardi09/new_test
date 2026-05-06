package com.epay.merchant.util;

import org.slf4j.MDC;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class ExceptionUtil {

    public static String getCorrelationId() {
        String correlationId = MDC.get("correlationId");
        return StringUtils.hasText(correlationId) ? correlationId : "NA";
    }
    public static String getRootPath(Exception e) {
        Throwable root = e;
        while (root.getCause() != null) {
            root = root.getCause();
        }
        StackTraceElement[] stackTrace = root.getStackTrace();
        if (ObjectUtils.isEmpty(stackTrace)) {return "unknown";}
        StackTraceElement element = stackTrace[0];

        return element.getClassName() + "." + element.getMethodName() + "(line:" + element.getLineNumber() + ")";
    }
}