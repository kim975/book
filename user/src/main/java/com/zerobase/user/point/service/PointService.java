package com.zerobase.user.point.service;

import com.zerobase.user.point.domain.repository.PointReader;
import com.zerobase.user.point.domain.repository.PointStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointReader pointReader;
    private final PointStore pointStore;

    public PointInfo.PointPaymentOrder registerPointChargeOrder(PointCommand.RegisterPointCharge command) {

        return PointInfo.PointPaymentOrder.fromEntity(
            pointStore.store(command.toEntity())
        );
    }

}
