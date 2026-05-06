package com.epay.merchant.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionLogDto {

    private String type;

    private String stacktrace;

    private String path;

    private String merchantId;

    private String correlationId;

    private String remark;

    private Long createdAt;

    private String createdBy;
}