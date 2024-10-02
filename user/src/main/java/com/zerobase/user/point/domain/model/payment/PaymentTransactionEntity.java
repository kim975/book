package com.zerobase.user.point.domain.model.payment;

public abstract class PaymentTransactionEntity {

    public abstract void setPaymentUuid(String token);

    public abstract long getPaymentTransactionId();

    public abstract String getTransactionUuid();
}
