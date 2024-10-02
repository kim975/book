package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.PointPaymentOrderEntity;
import com.zerobase.user.point.domain.repository.payment.KakaoPaymentTransactionRepository;
import com.zerobase.user.point.domain.repository.payment.TossPaymentTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PointStoreImpl implements PointStore {

    private final PointPaymentOrderRepository pointPaymentOrdersRepository;
    private final KakaoPaymentTransactionRepository kakaoPaymentTransactionRepository;
    private final TossPaymentTransactionRepository tossPaymentTransactionRepository;

    @Override
    public PointPaymentOrderEntity store(PointPaymentOrderEntity pointPaymentOrders) {
        return pointPaymentOrdersRepository.save(pointPaymentOrders);
    }
}
