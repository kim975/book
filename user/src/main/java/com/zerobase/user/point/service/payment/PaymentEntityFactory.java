package com.zerobase.user.point.service.payment;

import com.zerobase.user.exception.BaseException;
import com.zerobase.user.exception.PaymentErrorCode;
import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEntityFactory {

    private final List<Payment> paymentList;

    public PaymentTransactionEntity makePaymentTransactionEntity(PointPaymentOrderEntity pointPaymentOrder) {
        Payment payment = routingPayment(pointPaymentOrder);
        return payment.makeTransactionEntity(pointPaymentOrder);
    }

    private Payment routingPayment(PointPaymentOrderEntity pointPaymentOrder) {
        return paymentList.stream()
            .filter(payment -> payment.isSupport(pointPaymentOrder.getPaymentMethod()))
            .findFirst()
            .orElseThrow(() -> new BaseException(PaymentErrorCode.NOT_FOUND_PG));
    }
}
