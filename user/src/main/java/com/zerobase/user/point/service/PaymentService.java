package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.model.payment.PointPaymentOrderEntity;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import com.zerobase.user.point.domain.repository.payment.PaymentStore;
import com.zerobase.user.point.service.PaymentInfo.InitPointCharge;
import com.zerobase.user.point.service.payment.PaymentProcessor;
import com.zerobase.user.point.service.payment.PaymentEntityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentStore paymentStore;
    private final PaymentProcessor paymentProcessor;
    private final PaymentEntityFactory paymentEntityFactory;

    public InitPointCharge callPaymentOrder(PaymentCommand.InitPaymentOrder command) {

        PointPaymentOrderEntity storePointPaymentOrderEntity = paymentStore.store(command.toEntity());

        PaymentTransactionEntity paymentTransactionEntity = paymentEntityFactory.makePaymentTransactionEntity(storePointPaymentOrderEntity);
        PaymentTransactionEntity storeEntity = paymentStore.store(paymentTransactionEntity);

        paymentProcessor.initPaymentOrder(storeEntity, command.getPaymentMethod());

        return InitPointCharge.from(storePointPaymentOrderEntity, storeEntity);
    }

}
