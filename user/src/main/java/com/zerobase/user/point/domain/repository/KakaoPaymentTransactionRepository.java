package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.KakaoPaymentTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoPaymentTransactionRepository extends JpaRepository<KakaoPaymentTransactionEntity, Long> {
}
