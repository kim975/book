package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.PointPaymentOrderEntity;
import com.zerobase.user.point.domain.model.payment.PayStatus;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.TossPaymentTransactionEntity;
import com.zerobase.user.util.TokenGenerator;
import org.springframework.stereotype.Component;

@Component
public class TossPayment implements Payment {

    @Override
    public boolean isSupport(PaymentMethod paymentMethod) {
        return PaymentMethod.TOSS == paymentMethod;
    }

    @Override
    public PaymentTransactionEntity makeTransactionEntity(PointPaymentOrderEntity pointPaymentOrder) {
        return TossPaymentTransactionEntity.builder()
            .pointPaymentOrdersId(pointPaymentOrder.getId())
            .paymentKey(TokenGenerator.getToken())
            .orderId(TokenGenerator.getToken())
            .amount(pointPaymentOrder.getPaymentAmount())
            .status(PayStatus.IN_PROGRESS)
            .build();
    }
}
