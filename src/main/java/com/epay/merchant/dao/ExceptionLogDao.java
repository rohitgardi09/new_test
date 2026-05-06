package com.epay.merchant.dao;

import com.epay.merchant.dto.ExceptionLogDto;
import com.epay.merchant.entity.ExceptionLog;
import com.epay.merchant.mapper.ExceptionLogMapper;
import com.epay.merchant.repository.ExceptionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExceptionLogDao {

    private final ExceptionLogRepository exceptionLogRepository;

    private final ExceptionLogMapper exceptionLogMapper;

    public ExceptionLogDto saveExceptionLog(
            ExceptionLogDto exceptionLogDto) {

        ExceptionLog exceptionLog =
                exceptionLogMapper
                        .convertExceptionLogDtoToEntity(
                                exceptionLogDto);

        return exceptionLogMapper
                .convertExceptionLogToDto(
                        exceptionLogRepository
                                .save(exceptionLog));
    }
}