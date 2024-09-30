package com.zerobase.user.domain.repository;

import com.zerobase.user.domain.model.UserEntity;

public interface UserReader {

    boolean isExistsLoginId(String loginId);

    boolean isExistsNickname(String nickname);

    boolean isExistsEmail(String email);

    boolean isExistsPhoneNumber(String phoneNumber);

    UserEntity getUserByLoginIdAndPassword(String loginId, String password);
}
