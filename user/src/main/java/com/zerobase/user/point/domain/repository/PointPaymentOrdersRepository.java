package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.PointPaymentOrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointPaymentOrdersRepository extends JpaRepository<PointPaymentOrdersEntity, Long> {
}
