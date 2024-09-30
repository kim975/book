package com.zerobase.user.application;

import com.zerobase.user.service.UserCommand;
import com.zerobase.user.service.UserInfo;
import com.zerobase.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public void signUp(UserCommand.SignUpUser command) {
        userService.signUp(command);
    }

    public UserInfo.SignInInfo signIn(UserCommand.SignInUser command) {
        return userService.signIn(command);
    }

    public UserInfo.SignInInfo getUserByUserUuid(String userUuid) {
        return userService.getUserByUserUuid(userUuid);
    }
}
