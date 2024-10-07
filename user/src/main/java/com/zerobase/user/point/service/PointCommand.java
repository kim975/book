package com.zerobase.user.point.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PointCommand {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class AddPoint {

        private Long userId;
        private Long changePoint;
        private Long pointPaymentOrderId;
    }
}
