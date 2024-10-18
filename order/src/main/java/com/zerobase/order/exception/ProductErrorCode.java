package com.zerobase.order.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductErrorCode implements ErrorCode {

    NOT_FOUND_PRODUCT("E21001", "상품을 찾을 수 없습니다.");

    private final String errorCode;
    private final String errorMessage;

}
