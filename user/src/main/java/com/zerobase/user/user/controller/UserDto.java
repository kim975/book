package com.zerobase.user.user.controller;

import com.zerobase.user.user.service.UserCommand;
import com.zerobase.user.user.service.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserDto {

    @Getter
    @Setter
    @ToString
    public static class SignUpRequest {

        private String loginId;
        private String password;
        private String name;
        private String nickname;
        private String email;
        private String phoneNumber;

        public UserCommand.SignUpUser toCommand() {
            return UserCommand.SignUpUser.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .nickname(nickname)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class SignInRequest {

        private String loginId;
        private String password;

        public UserCommand.SignInUser toCommand() {
            return UserCommand.SignInUser.builder()
                .loginId(loginId)
                .password(password)
                .build();
        }
    }

    @Getter
    @Setter
    @ToString
    @Builder
    public static class SignInResponse {

        private String nickname;

        public static UserDto.SignInResponse from(UserInfo.SignInInfo user) {
            return SignInResponse.builder()
                .nickname(user.getNickname())
                .build();
        }
    }
}
