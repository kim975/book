package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.PaymentStatus;
import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointCommand {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class RegisterPointChargeOrder {

        private Long userId;
        private Long paymentAmount;
        private PaymentMethod paymentMethod;

        public PointPaymentOrderEntity toEntity() {
            return PointPaymentOrderEntity.builder()
                .userId(userId)
                .paymentAmount(paymentAmount)
                .paymentStatus(PaymentStatus.IN_PROGRESS)
                .paymentMethod(paymentMethod)
                .build();
        }
    }

    public static class AddPoint {

    }
}
