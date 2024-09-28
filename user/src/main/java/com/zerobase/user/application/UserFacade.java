package com.zerobase.user.application;

import com.zerobase.user.service.UserService;
import com.zerobase.user.service.UserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public void signUp(UserCommand.SignUpUser command) {
        userService.signUp(command);
    }

}
