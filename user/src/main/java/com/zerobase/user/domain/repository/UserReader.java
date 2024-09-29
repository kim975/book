package com.zerobase.user.domain.repository;

public interface UserReader {

    boolean isExistsLoginId(String loginId);

    boolean isExistsNickname(String nickname);

    boolean isExistsEmail(String email);

    boolean isExistsPhoneNumber(String phoneNumber);


}
