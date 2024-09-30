package com.zerobase.user.service;

import com.zerobase.user.domain.model.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserInfo {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class SignInInfo {
        private String nickname;
        private String userUuid;

        public static UserInfo.SignInInfo fromEntity(UserEntity user) {
            return UserInfo.SignInInfo.builder()
                    .nickname(user.getNickname())
                    .userUuid(user.getUserUuid())
                    .build();
        }

    }

}
