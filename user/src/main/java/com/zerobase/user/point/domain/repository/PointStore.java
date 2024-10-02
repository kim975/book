package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;

public interface PointStore {

    PointPaymentOrderEntity store(PointPaymentOrderEntity pointPaymentOrders);

}
