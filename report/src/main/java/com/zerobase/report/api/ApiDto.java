package com.zerobase.report.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiDto<T> {

    private String result;
    private T data;
    private String message;
    private String errorCode;
}
