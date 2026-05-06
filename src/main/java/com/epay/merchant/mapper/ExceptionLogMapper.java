package com.epay.merchant.mapper;

import com.epay.merchant.dto.ExceptionLogDto;
import com.epay.merchant.entity.ExceptionLog;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface ExceptionLogMapper {

    ExceptionLogDto convertExceptionLogToDto(ExceptionLog exceptionLog);

    ExceptionLog convertExceptionLogDtoToEntity(ExceptionLogDto exceptionLogDto);
}