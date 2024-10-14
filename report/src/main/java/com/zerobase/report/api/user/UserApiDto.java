package com.zerobase.report.api.user;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class UserApiDto {

    @Getter
    @Setter
    @ToString
    public static class UserDetail {

        private String result;
        private Data data;
        private String message;
        private String errorCode;
    }

    @Getter
    @Setter
    @ToString
    public static class UserDetailList {

        private String result;
        private List<Data> data;
        private String message;
        private String errorCode;
    }

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
