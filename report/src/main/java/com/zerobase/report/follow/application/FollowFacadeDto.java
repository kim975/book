package com.zerobase.report.follow.application;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FollowFacadeDto {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class MainRequest {

        private String userUuid;
        private String followUserNickName;

    }

}
