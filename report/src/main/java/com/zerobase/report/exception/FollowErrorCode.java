package com.zerobase.report.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FollowErrorCode implements ErrorCode {

    NOT_FOUND_FOLLOW("E13001", "팔로우 정보를 찾을 수 없습니다.");

    private final String errorCode;
    private final String errorMessage;
}
