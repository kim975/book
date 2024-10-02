package com.zerobase.user.point.domain.repository.payment;

import com.zerobase.user.point.domain.model.payment.KakaoPaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.domain.model.payment.TossPaymentTransactionEntity;

public interface PaymentTransactionStore {

    public PaymentTransactionEntity store(PaymentTransactionEntity paymentTransactionEntity);

}
