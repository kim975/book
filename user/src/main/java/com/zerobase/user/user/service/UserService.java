package com.zerobase.user.user.service;

import com.zerobase.user.user.domain.model.UserEntity;
import com.zerobase.user.user.domain.model.UserRole;
import com.zerobase.user.user.domain.repository.UserReader;
import com.zerobase.user.user.domain.repository.UserStore;
import com.zerobase.user.exception.BaseException;
import com.zerobase.user.exception.UserErrorCode;
import com.zerobase.user.util.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStore userStore;
    private final UserReader userReader;

    public void signUp(UserCommand.SignUpUser command) {
        validateSignUp(command);

        UserEntity users = command.toEntity();
        users.setUserUuid(TokenGenerator.getToken());
        users.setUserRoles(List.of(UserRole.ROLE_USER));

        userStore.store(users);
    }

    public UserInfo.SignInInfo signIn(UserCommand.SignInUser command) {
        UserEntity user = userReader.getUserByLoginIdAndPassword(command.getLoginId(), command.getPassword());

        validateSignIn(user);

        return UserInfo.SignInInfo.fromEntity(user);
    }

    public UserInfo.SignInInfo getUserByUserUuid(String userUuid) {
        return UserInfo.SignInInfo.fromEntity(userReader.getUserByUserUuid(userUuid));
    }

    private void validateSignUp(UserCommand.SignUpUser command) {

        if (userReader.isExistsLoginId(command.getLoginId())) {
            throw new BaseException(UserErrorCode.DUPLICATE_LOGIN_ID);
        }

        if (userReader.isExistsNickname(command.getNickname())) {
            throw new BaseException(UserErrorCode.DUPLICATE_NICKNAME);
        }

        if (userReader.isExistsEmail(command.getEmail())) {
            throw new BaseException(UserErrorCode.DUPLICATE_EMAIL);
        }

        if (userReader.isExistsPhoneNumber(command.getPhoneNumber())) {
            throw new BaseException(UserErrorCode.DUPLICATE_PHONE_NUMBER);
        }
    }

    private void validateSignIn(UserEntity user) {

        if (user.getLeaveDateTime() != null) {
            throw new BaseException(UserErrorCode.LEAVED_USER);
        }
    }
}
