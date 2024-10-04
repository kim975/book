package com.zerobase.user.point.application;

import static com.zerobase.user.point.application.PointFacadeDto.*;
import static com.zerobase.user.point.service.PaymentInfo.InitPointCharge;

import com.zerobase.user.point.service.PaymentService;
import com.zerobase.user.point.service.PointService;
import com.zerobase.user.user.service.UserInfo.SignInInfo;
import com.zerobase.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PointFacade {

    private final PointService pointService;
    private final PaymentService paymentService;
    private final UserService userService;

    @Transactional
    public InitPointChargeResponse initPointChargeOrder(InitPointChargeRequest dto) {

        SignInInfo userInfo = userService.getUserByUserUuid(dto.getUserUuid());

        InitPointCharge paymentOrder = paymentService.callPaymentOrder(dto.toCommand(userInfo.getId()));

        return InitPointChargeResponse.from(paymentOrder);
    }

}
