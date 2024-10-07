package com.zerobase.user.user.controller;

import com.zerobase.user.common.response.CommonResponse;
import com.zerobase.user.user.application.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/api/v1")
public class UserInternalApiController {

    private final UserFacade userFacade;

    @GetMapping("/user/{userUuid}")
    public CommonResponse<UserInternalApiDto.UserDetailResponse> getUser(
        @PathVariable("userUuid") String userUuid
    ) {
        return CommonResponse.success(
            UserInternalApiDto.UserDetailResponse.from(userFacade.getUserDetailByUserUuid(userUuid))
        );
    }

}
