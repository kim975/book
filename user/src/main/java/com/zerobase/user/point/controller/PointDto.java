package com.zerobase.user.point.controller;

import com.zerobase.user.point.application.PointFacadeDto;
import com.zerobase.user.point.domain.model.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointDto {

    @Getter
    @Setter
    @ToString
    public static class InitPointChargeOrderRequest {

        private Long paymentAmount;
        private String paymentMethod;

        public PointFacadeDto.InitPointChargeRequest toFacadeDto(String userUuid) {
            return PointFacadeDto.InitPointChargeRequest.builder()
                .userUuid(userUuid)
                .paymentAmount(paymentAmount)
                .paymentMethod(PaymentMethod.valueOf(paymentMethod))
                .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @ToString
    public static class InitPointChargeOrderResponse {

        private Long pointPaymentOrderId;
        private Long paymentAmount;
        private String paymentMethod;
        private String paymentUuid;
        private String paymentStatus;

        public static InitPointChargeOrderResponse from(PointFacadeDto.InitPointChargeResponse facadeDto) {
            return PointDto.InitPointChargeOrderResponse.builder()
                .pointPaymentOrderId(facadeDto.getPointPaymentOrderId())
                .paymentAmount(facadeDto.getPaymentAmount())
                .paymentMethod(facadeDto.getPaymentMethod().toString())
                .paymentStatus(facadeDto.getPaymentStatus().toString())
                .paymentUuid(facadeDto.getPaymentUuid())
                .build();
        }

    }

    public static class PayPointChargeRequest {

    }

    public static class PayPointChargeResponse {

    }

}
