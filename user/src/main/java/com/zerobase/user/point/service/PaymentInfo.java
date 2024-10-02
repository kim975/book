package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.PaymentStatus;
import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PaymentInfo {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class InitPointCharge {

        private String paymentUuid;
        private Long paymentAmount;
        private PaymentMethod paymentMethod;
        private PaymentStatus paymentStatus;


        public static InitPointCharge from(PointPaymentOrderEntity pointPaymentOrder, PaymentTransactionEntity paymentTransaction) {
            return InitPointCharge.builder()
                .paymentUuid(paymentTransaction.getTransactionUuid())
                .paymentAmount(pointPaymentOrder.getPaymentAmount())
                .paymentMethod(pointPaymentOrder.getPaymentMethod())
                .paymentStatus(pointPaymentOrder.getPaymentStatus())
                .build();
        }

    }
}
