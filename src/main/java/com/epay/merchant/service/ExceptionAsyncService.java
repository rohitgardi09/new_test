package com.epay.merchant.service;

import com.epay.merchant.dao.ExceptionLogDao;
import com.epay.merchant.dto.ExceptionLogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExceptionAsyncService {

    private final ExceptionLogDao exceptionLogDao;

    @Async("exceptionExecutor")
    public void store(ExceptionLogDto exceptionLogDto) {
        try {
            exceptionLogDao.saveExceptionLog(exceptionLogDto);
        } catch (Exception ex)
        {
            log.error("Failed to store exception", ex);
        }
    }
}