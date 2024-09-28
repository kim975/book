package com.zerobase.user.service;

public interface UserReader {

    boolean isExistsLoginId(String loginId);
    boolean isExistsNickname(String nickname);
    boolean isExistsEmail(String email);
    boolean isExistsPhoneNumber(String phoneNumber);


}
