package com.zerobase.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasicErrorCode implements ErrorCode{

    COMMON_SYSTEM_ERROR("E01001", "시스템 에러가 발생했습니다.");

    private final String errorCode;
    private final String errorMessage;

}
