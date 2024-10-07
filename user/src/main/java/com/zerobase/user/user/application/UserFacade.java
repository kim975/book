package com.zerobase.user.user.application;

import com.zerobase.user.user.service.UserCommand;
import com.zerobase.user.user.service.UserInfo;
import com.zerobase.user.user.service.UserService;
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

    public UserInfo.SignInInfo getUserAuthenticByUserUuid(String userUuid) {
        return userService.getUserAuthenticByUserUuid(userUuid);
    }

    public UserInfo.UserDetail getUserDetailByUserUuid(String userUuid) {
        return userService.getUserDetailByUuid(userUuid);
    }

    public UserInfo.UserDetail modifyUser(UserCommand.ModifyUser command) {
        return userService.modifyUserInfo(command);
    }

    public UserInfo.UserDetail leaveUser(String userUuid) {
        return userService.leaveUser(userUuid);
    }
}
