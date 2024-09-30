package com.zerobase.user.service;

import com.zerobase.user.domain.model.UserEntity;
import com.zerobase.user.domain.repository.UserReader;
import com.zerobase.user.domain.repository.UserStore;
import com.zerobase.user.exception.BaseException;
import com.zerobase.user.exception.UserErrorCode;
import com.zerobase.user.util.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    static final int USER_LEAVE_STORAGE_MONTH = 1;

    private final UserStore userStore;
    private final UserReader userReader;

    public void signUp(UserCommand.SignUpUser command) {
        validateSignUp(command);

        UserEntity users = command.toEntity();
        users.setUserUuid(TokenGenerator.getToken());

        userStore.store(users);
    }

    public UserInfo.SignInInfo signIn(UserCommand.SignInUser command) {
        UserEntity user = userReader.getUserByLoginIdAndPassword(command.getLoginId(), command.getPassword());

        validateSignIn(user);

        return UserInfo.SignInInfo.fromEntity(user);
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
