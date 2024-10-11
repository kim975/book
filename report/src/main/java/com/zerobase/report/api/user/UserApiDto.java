package com.zerobase.report.api.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserApiDto {

    private String result;
    private Data data;
    private String message;
    private String errorCode;

    @Getter
    @Setter
    @ToString
    public static class Data {

        private Long id;
        private String loginId;
        private String name;
        private String nickname;
        private String email;
        private String phoneNumber;
        private String userUuid;
    }
}
