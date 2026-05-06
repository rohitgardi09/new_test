package com.epay.merchant.service;

import com.epay.merchant.dto.ExceptionLogDto;
import com.epay.merchant.util.ExceptionUtil;
import com.epay.merchant.util.StackTraceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ExceptionLogService {

    private final ExceptionAsyncService exceptionAsyncService;

    public void logException(Exception e, String merchantId, String remark) {

        ExceptionLogDto dto = buildExceptionLogDto(e, merchantId, remark);
        exceptionAsyncService.store(dto);
    }

    private ExceptionLogDto buildExceptionLogDto(Exception e, String merchantId, String remark) {

        return ExceptionLogDto.builder().type(e.getClass().getName())
                .stacktrace(StackTraceUtil.getShortStackTrace((Throwable)e))
                .path(ExceptionUtil.getRootPath(e))
                .merchantId(StringUtils.hasText(merchantId) ? merchantId : "NA")
                .correlationId(ExceptionUtil.getCorrelationId())
                .remark(StringUtils.hasText(remark) ? remark : e.getMessage())
                .createdAt(System.currentTimeMillis())
                .createdBy(StringUtils.hasText(merchantId) ? merchantId : "SYSTEM")
                .build();
    }
}