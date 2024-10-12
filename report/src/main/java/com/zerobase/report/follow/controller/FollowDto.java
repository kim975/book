package com.zerobase.report.follow.controller;

import lombok.Getter;
import lombok.Setter;

public class FollowDto {

    @Getter
    @Setter
    public static class RegisterFollowRequest {

        private String followUserNickName;
    }

    @Getter
    @Setter
    public static class UnfollowRequest {

        private String followUserNickName;
    }
}
