package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.PaymentStatus;
import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointInfo {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class PointPaymentOrder {

        private long id;
        private Long paymentAmount;
        private PaymentMethod paymentMethod;
        private PaymentStatus paymentStatus;

        public static PointPaymentOrder fromEntity(PointPaymentOrderEntity entity) {
            return PointPaymentOrder.builder()
                .id(entity.getId())
                .paymentAmount(entity.getPaymentAmount())
                .paymentMethod(entity.getPaymentMethod())
                .paymentStatus(entity.getPaymentStatus())
                .build();
        }

    }

}
