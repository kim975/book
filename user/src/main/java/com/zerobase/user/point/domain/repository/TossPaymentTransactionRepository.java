package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.TossPaymentTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TossPaymentTransactionRepository extends JpaRepository<TossPaymentTransactionEntity, Long> {
}
