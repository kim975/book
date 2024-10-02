package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.KakaoPaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KakaoPaymentApiCaller implements PaymentApiCaller {

    @Override
    public boolean isSupport(PaymentMethod paymentMethod) {
        return PaymentMethod.KAKAO == paymentMethod;
    }

    @Override
    public void pay() {
        // PG 연동 대신 log로 대체
    }

    @Override
    public void initPaymentOrder(PaymentTransactionEntity entity) {

        // PG 연동 대신 log로 대체
        KakaoPaymentTransactionEntity kakaoEntity = (KakaoPaymentTransactionEntity) entity;

        log.info(kakaoEntity.toString());
    }
}
