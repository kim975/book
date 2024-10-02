package com.zerobase.user.point.service.payment;

import com.zerobase.user.exception.BaseException;
import com.zerobase.user.exception.BasicErrorCode;
import com.zerobase.user.point.domain.model.PaymentMethod;
import com.zerobase.user.point.domain.model.payment.PaymentTransactionEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProcessor {

    private final List<PaymentApiCaller> paymentApiCallerList;

    public void createPaymentOrder(PaymentTransactionEntity entity, PaymentMethod paymentMethod) {
        PaymentApiCaller payApiCaller = routingApiCaller(paymentMethod);
        payApiCaller.createPaymentOrder(entity);
    }

    public void pay() {
//        for (int i = 0; i < paymentApiCallerList; i++) {
//            issuport
//                get().pay();
//        }
    }

    private PaymentApiCaller routingApiCaller(PaymentMethod paymentMethod) {
        return paymentApiCallerList.stream()
            .filter(paymentApiCaller -> paymentApiCaller.isSupport(paymentMethod))
            .findFirst()
            .orElseThrow(() -> new BaseException(BasicErrorCode.COMMON_SYSTEM_ERROR));
    }
}
