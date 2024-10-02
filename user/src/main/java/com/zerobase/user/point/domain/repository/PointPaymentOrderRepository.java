package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointPaymentOrderRepository extends JpaRepository<PointPaymentOrderEntity, Long> {

}
