package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.PointPaymentOrdersEntity;

public interface PointStore {

    PointPaymentOrdersEntity store(PointPaymentOrdersEntity pointPaymentOrders);

}
