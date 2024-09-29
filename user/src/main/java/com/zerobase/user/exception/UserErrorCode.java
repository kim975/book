package com.zerobase.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {


    DUPLICATE_EMAIL("E02001", "이메일이 중복 됩니다."),
    DUPLICATE_NICKNAME("E02002", "닉네임이 중복 됩니다."),
    DUPLICATE_PHONE_NUMBER("E02003", "휴대폰 번호가 중복 됩니다."),
    DUPLICATE_LOGIN_ID("E02004", "아이디가 중복 됩니다.");

    private final String errorCode;
    private final String errorMessage;

}
