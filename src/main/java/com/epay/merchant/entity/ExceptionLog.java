package com.epay.merchant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exception_log")
public class ExceptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false, unique = true)
    private UUID id;

    private String type;

    @Lob
    private String stacktrace;

    private String path;

    @Column(name = "MID")
    private String merchantId;

    @Column(name = "correlation_id")
    private String correlationId;

    private String remark;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_AT")
    private Long createdAt;
}