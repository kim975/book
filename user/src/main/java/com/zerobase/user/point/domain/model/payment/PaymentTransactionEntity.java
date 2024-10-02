package com.zerobase.user.point.domain.model.payment;

import com.zerobase.user.point.domain.model.PointPaymentOrdersEntity;

public abstract class PaymentTransactionEntity {

    public abstract void setPaymentUuid(String token);

    public abstract long getPaymentTransactionId();

    public abstract String getTransactionUuid();
}
