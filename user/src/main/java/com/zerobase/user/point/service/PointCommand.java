package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.PaymentStatus;
import com.zerobase.user.point.domain.model.PointPaymentOrdersEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointCommand {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class RegisterPointCharge {

        private Long userId;
        private Long paymentAmount;
        private PaymentMethod paymentMethod;

        public PointPaymentOrdersEntity toEntity() {
            return PointPaymentOrdersEntity.builder()
                .userId(userId)
                .paymentAmount(paymentAmount)
                .paymentStatus(PaymentStatus.IN_PROGRESS)
                .paymentMethod(paymentMethod)
                .build();
        }
    }

}
