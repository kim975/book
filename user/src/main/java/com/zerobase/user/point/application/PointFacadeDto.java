package com.zerobase.user.point.application;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.PaymentStatus;
import com.zerobase.user.point.service.PaymentInfo;
import com.zerobase.user.point.service.PointCommand;
import com.zerobase.user.point.service.PointInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointFacadeDto {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class InitPointChargeRequest {

        private String userUuid;
        private Long paymentAmount;
        private PaymentMethod paymentMethod;

        public PointCommand.RegisterPointChargeOrder toCommand(Long userId) {
            return PointCommand.RegisterPointChargeOrder.builder()
                    .userId(userId)
                    .paymentAmount(paymentAmount)
                    .paymentMethod(paymentMethod)
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @ToString
    public static class InitPointChargeResponse {

        private Long paymentAmount;
        private PaymentMethod paymentMethod;
        private String paymentUuid;
        private PaymentStatus paymentStatus;

        public static InitPointChargeResponse from(
                PointInfo.PointPaymentOrder pointPaymentOrderInfo,
                PaymentInfo.PaymentTransaction paymentInfo
        ) {
            return InitPointChargeResponse.builder()
                    .paymentAmount(pointPaymentOrderInfo.getPaymentAmount())
                    .paymentMethod(pointPaymentOrderInfo.getPaymentMethod())
                    .paymentStatus(pointPaymentOrderInfo.getPaymentStatus())
                    .paymentUuid(paymentInfo.getPaymentUuid())
                    .build();
        }
    }

}
