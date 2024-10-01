package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<PointEntity, Long> {
}
