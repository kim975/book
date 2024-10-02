package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.model.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PaymentCommand {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class CreatePaymentOrder {

        private Long pointPaymentOrdersId;
        private Long amount;
        private PaymentMethod paymentMethod;

        public static PaymentCommand.CreatePaymentOrder from(PointInfo.PointPaymentOrder pointPaymentOrders) {
            return CreatePaymentOrder.builder()
                .pointPaymentOrdersId(pointPaymentOrders.getId())
                .amount(pointPaymentOrders.getPaymentAmount())
                .paymentMethod(pointPaymentOrders.getPaymentMethod())
                .build();
        }
    }

}
