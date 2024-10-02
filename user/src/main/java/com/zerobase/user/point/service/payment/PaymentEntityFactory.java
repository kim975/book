package com.zerobase.user.point.service.payment;


import com.zerobase.user.exception.BaseException;
import com.zerobase.user.exception.BasicErrorCode;
import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.KakaoPaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.PayStatus;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.TossPaymentTransactionEntity;
import com.zerobase.user.point.service.PaymentCommand;
import com.zerobase.user.util.TokenGenerator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEntityFactory {

    private final List<Payment> paymentList;

    public PaymentTransactionEntity makePaymentTransactionEntity(PaymentCommand.CreatePaymentOrder command) {
        Payment payment = routingPayment(command);
        return payment.makeTransactionEntity(command);
    }

    private Payment routingPayment(PaymentCommand.CreatePaymentOrder command) {
        return paymentList.stream()
            .filter(payment -> payment.isSupport(command.getPaymentMethod()))
            .findFirst()
            .orElseThrow(() -> new BaseException(BasicErrorCode.COMMON_SYSTEM_ERROR));
    }
}
