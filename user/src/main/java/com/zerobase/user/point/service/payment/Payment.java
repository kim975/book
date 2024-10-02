package com.zerobase.user.point.service.payment;

import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.service.PaymentCommand;

public interface Payment {

    boolean isSupport(PaymentMethod paymentMethod);

    PaymentTransactionEntity makeTransactionEntity(PaymentCommand.RegisterPaymentTransaction command);

}
