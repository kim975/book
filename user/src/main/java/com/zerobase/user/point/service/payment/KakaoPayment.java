package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.KakaoPaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.PayStatus;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.service.PaymentCommand.CreatePaymentOrder;
import com.zerobase.user.util.TokenGenerator;
import org.springframework.stereotype.Component;

@Component
public class KakaoPayment implements Payment {

    //가맹정 코드
    private static final String CID = "가맹점1234567890";

    @Override
    public boolean isSupport(PaymentMethod paymentMethod) {
        return PaymentMethod.KAKAO == paymentMethod;
    }

    @Override
    public PaymentTransactionEntity makeTransactionEntity(CreatePaymentOrder command) {
        return KakaoPaymentTransactionEntity.builder()
            .cid(CID)
            .tid(TokenGenerator.getToken())
            .totalAmount(command.getAmount())
            .pointPaymentOrdersId(command.getPointPaymentOrdersId())
            .status(PayStatus.IN_PROGRESS)
            .build();
    }
}
