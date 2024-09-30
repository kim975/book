package com.zerobase.user.controller;

import com.zerobase.user.application.UserFacade;
import com.zerobase.user.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/signup")
    public CommonResponse signUp(
            @RequestBody UserDto.SignUpRequest request
    ) {
        userFacade.signUp(request.toCommand());
        return CommonResponse.success();
    }

    @PostMapping("/signin")
    public CommonResponse signIn(
            @RequestBody UserDto.SignInRequest request
    ) {
        return CommonResponse.success(userFacade.signIn(request.toCommand()));
    }
}
