package com.zerobase.user.point.controller;

import com.zerobase.user.common.response.CommonResponse;
import com.zerobase.user.point.application.PointFacade;
import com.zerobase.user.point.controller.PointDto.RegisterPointChargeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointFacade pointFacade;

    @PostMapping("/point/init")
    public CommonResponse<RegisterPointChargeResponse> pointChargeRequest(
        Authentication authentication,
        @RequestBody PointDto.RegisterPointChargeRequest request
    ) {

        return CommonResponse.success(
            PointDto.RegisterPointChargeResponse.from(pointFacade.registerPointChargeOrder(request.toFacadeDto(authentication.getName())))
        );
    }


}
