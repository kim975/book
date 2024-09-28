package com.zerobase.user.controller;

import com.zerobase.user.service.UserCommand;
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

}
