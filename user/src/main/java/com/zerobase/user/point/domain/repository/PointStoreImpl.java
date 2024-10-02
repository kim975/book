package com.zerobase.user.point.domain.repository;

import com.zerobase.user.point.domain.model.PointPaymentOrdersEntity;
import com.zerobase.user.point.domain.repository.payment.KakaoPaymentTransactionRepository;
import com.zerobase.user.point.domain.repository.payment.TossPaymentTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PointStoreImpl implements PointStore {

    private final PointPaymentOrdersRepository pointPaymentOrdersRepository;
    private final KakaoPaymentTransactionRepository kakaoPaymentTransactionRepository;
    private final TossPaymentTransactionRepository tossPaymentTransactionRepository;

    @Override
    public PointPaymentOrdersEntity store(PointPaymentOrdersEntity pointPaymentOrders) {
        return pointPaymentOrdersRepository.save(pointPaymentOrders);
    }
}
