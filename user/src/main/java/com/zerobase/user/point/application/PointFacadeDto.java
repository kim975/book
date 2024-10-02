package com.zerobase.user.point.application;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.PaymentStatus;
import com.zerobase.user.point.service.PaymentInfo;
import com.zerobase.user.point.service.PointCommand;
import com.zerobase.user.point.service.PointInfo.PointPaymentOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointFacadeDto {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class RegisterPointChargeOrderRequest {

        private String userUuid;
        private Long paymentAmount;
        private PaymentMethod paymentMethod;

        public PointCommand.RegisterPointCharge toCommand(Long userId) {
            return PointCommand.RegisterPointCharge.builder()
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
    public static class RegisterPointChargeOrderResponse {

        private Long paymentAmount;
        private PaymentMethod paymentMethod;
        private String paymentUuid;
        private PaymentStatus paymentStatus;

        public static PointFacadeDto.RegisterPointChargeOrderResponse from(
            PointPaymentOrder pointInfo,
            PaymentInfo.RegisterPointChargeOrder paymentInfo
        ) {
            return RegisterPointChargeOrderResponse.builder()
                .paymentAmount(pointInfo.getPaymentAmount())
                .paymentMethod(pointInfo.getPaymentMethod())
                .paymentStatus(pointInfo.getPaymentStatus())
                .paymentUuid(paymentInfo.getPaymentUuid())
                .build();
        }
    }

}
