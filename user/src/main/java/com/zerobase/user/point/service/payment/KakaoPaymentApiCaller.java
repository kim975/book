package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.KakaoPaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KakaoPaymentApiCaller implements PaymentApiCaller{

    @Override
    public boolean isSupport(PaymentMethod paymentMethod) {
        return PaymentMethod.KAKAO == paymentMethod;
    }

    @Override
    public void pay() {
        //실제로 결제
    }

    @Override
    public void createPaymentOrder(PaymentTransactionEntity entity) {

        KakaoPaymentTransactionEntity kakaoEntity = (KakaoPaymentTransactionEntity) entity;

        log.info(kakaoEntity.toString());
    }
}
