package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.PayStatus;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.TossPaymentTransactionEntity;
import com.zerobase.user.point.service.PaymentCommand.CreatePaymentOrder;
import com.zerobase.user.util.TokenGenerator;
import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Component;

@Component
public class TossPayment implements Payment {

    @Override
    public boolean isSupport(PaymentMethod paymentMethod) {
        return PaymentMethod.TOSS == paymentMethod;
    }

    @Override
    public PaymentTransactionEntity makeTransactionEntity(CreatePaymentOrder command) {
        return TossPaymentTransactionEntity.builder()
            .pointPaymentOrdersId(command.getPointPaymentOrdersId())
            .status(PayStatus.IN_PROGRESS)
            .paymentKey(TokenGenerator.getToken())
            .orderId(TokenGenerator.getToken())
            .amount(command.getAmount())
            .build();
    }
}
