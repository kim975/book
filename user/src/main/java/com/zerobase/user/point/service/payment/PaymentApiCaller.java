package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;

public interface PaymentApiCaller {
    boolean isSupport(PaymentMethod paymentMethod);

    void pay();

    void initPaymentOrder(PaymentTransactionEntity entity);
}