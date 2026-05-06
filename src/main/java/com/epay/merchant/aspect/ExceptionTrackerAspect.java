package com.epay.merchant.aspect;

import com.epay.merchant.annotation.TrackException;
import com.epay.merchant.service.ExceptionLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExceptionTrackerAspect {

    private final ExceptionLogService exceptionLogService;

    @Around("@annotation(trackException)")
    public Object trackException(
            ProceedingJoinPoint joinPoint,
            TrackException trackException)
            throws Throwable {

        try {
            return joinPoint.proceed();
        } catch (Throwable ex) {
            String merchantId = MDC.get("MID");

            String remark = joinPoint.getSignature().getName();

            exceptionLogService.logException(new Exception(ex), merchantId, remark);

            if (trackException.rethrow()) {
                throw ex;
            }

            return null;
        }
    }
}