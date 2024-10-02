package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.KakaoPaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.TossPaymentTransactionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TossPaymentApiCaller implements PaymentApiCaller{

    @Override
    public boolean isSupport(PaymentMethod paymentMethod) {
        return PaymentMethod.TOSS == paymentMethod;
    }

    @Override
    public void pay() {
        //실제로 결제
    }

    @Override
    public void createPaymentOrder(PaymentTransactionEntity entity) {

        TossPaymentTransactionEntity tossEntity = (TossPaymentTransactionEntity) entity;

        log.info(tossEntity.toString());
    }
}
