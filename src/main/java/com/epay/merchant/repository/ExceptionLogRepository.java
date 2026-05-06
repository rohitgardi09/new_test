package com.epay.merchant.repository;

import com.epay.merchant.entity.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExceptionLogRepository extends JpaRepository<ExceptionLog, UUID> {
}