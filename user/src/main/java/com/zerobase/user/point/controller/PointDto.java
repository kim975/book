package com.zerobase.user.point.controller;

import com.zerobase.user.point.application.PointFacadeDto;
import com.zerobase.user.point.application.PointFacadeDto.RegisterPointChargeOrderRequest;
import com.zerobase.user.point.domain.model.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterPointChargeRequest {

        private Long paymentAmount;
        private String paymentMethod;

        public RegisterPointChargeOrderRequest toFacadeDto(String userUuid) {
            return RegisterPointChargeOrderRequest.builder()
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
    public static class RegisterPointChargeResponse {
        private Long paymentAmount;
        private String paymentMethod;
        private String paymentUuid;
        private String paymentStatus;

        public static PointDto.RegisterPointChargeResponse from (PointFacadeDto.RegisterPointChargeOrderResponse facadeDto) {
            return RegisterPointChargeResponse.builder()
                .paymentAmount(facadeDto.getPaymentAmount())
                .paymentMethod(facadeDto.getPaymentMethod().toString())
                .paymentStatus(facadeDto.getPaymentStatus().toString())
                .paymentUuid(facadeDto.getPaymentUuid())
                .build();
        }

    }

}
