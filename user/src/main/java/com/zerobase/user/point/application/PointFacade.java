package com.zerobase.user.point.application;

import com.zerobase.user.point.application.PointFacadeDto.RegisterPointChargeOrderRequest;
import com.zerobase.user.point.service.PaymentCommand.CreatePaymentOrder;
import com.zerobase.user.point.service.PaymentInfo.RegisterPointChargeOrder;
import com.zerobase.user.point.service.PaymentService;
import com.zerobase.user.point.service.PointInfo;
import com.zerobase.user.point.service.PointService;
import com.zerobase.user.service.UserInfo.SignInInfo;
import com.zerobase.user.service.UserService;
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
    public PointFacadeDto.RegisterPointChargeOrderResponse registerPointChargeOrder(RegisterPointChargeOrderRequest dto) {

        SignInInfo userInfo = userService.getUserByUserUuid(dto.getUserUuid());

        PointInfo.PointPaymentOrder pointPaymentOrders = pointService.registerPointChargeOrder(dto.toCommand(userInfo.getId()));

        RegisterPointChargeOrder paymentOrder = paymentService.callPaymentOrder(CreatePaymentOrder.from(pointPaymentOrders));

        return PointFacadeDto.RegisterPointChargeOrderResponse.from(pointPaymentOrders, paymentOrder);
    }


}
