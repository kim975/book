package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.domain.repository.payment.PaymentTransactionStore;
import com.zerobase.user.point.service.payment.PaymentProcessor;
import com.zerobase.user.point.service.payment.PaymentEntityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentTransactionStore paymentTransactionStore;
    private final PaymentProcessor paymentProcessor;
    private final PaymentEntityFactory paymentEntityFactory;

    public PaymentInfo.RegisterPointChargeOrder callPaymentOrder(PaymentCommand.CreatePaymentOrder command) {
        PaymentTransactionEntity paymentTransactionEntity = paymentEntityFactory.makePaymentTransactionEntity(command);
        PaymentTransactionEntity storeEntity = paymentTransactionStore.store(paymentTransactionEntity);

        paymentProcessor.createPaymentOrder(storeEntity, command.getPaymentMethod());

        return PaymentInfo.RegisterPointChargeOrder.from(storeEntity);
    }

}
