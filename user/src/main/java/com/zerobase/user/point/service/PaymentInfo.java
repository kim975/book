package com.zerobase.user.point.service;

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
    public static class PaymentTransaction {

        private Long paymentTransactionId;
        private String paymentUuid;

        public static PaymentTransaction from(PaymentTransactionEntity paymentTransactionEntity) {
            return PaymentTransaction.builder()
                    .paymentTransactionId(paymentTransactionEntity.getPaymentTransactionId())
                    .paymentUuid(paymentTransactionEntity.getTransactionUuid())
                    .build();
        }

    }
}
