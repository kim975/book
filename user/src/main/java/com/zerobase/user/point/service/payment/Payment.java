package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;

public interface Payment {

    boolean isSupport(PaymentMethod paymentMethod);

    PaymentTransactionEntity makeTransactionEntity(PointPaymentOrderEntity pointPaymentOrder);

}
