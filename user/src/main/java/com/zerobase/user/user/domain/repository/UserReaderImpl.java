package com.zerobase.user.user.domain.repository;

import com.zerobase.user.user.domain.model.UserEntity;
import com.zerobase.user.exception.BaseException;
import com.zerobase.user.exception.UserErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserRepository userRepository;


    @Override
    public boolean isExistsLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }

    @Override
    public boolean isExistsNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    @Override
    public boolean isExistsEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean isExistsPhoneNumber(String phoneNumber) {
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public UserEntity getUserByLoginIdAndPassword(String loginId, String password) {
        return userRepository.findByLoginIdAndPassword(loginId, password)
            .orElseThrow(() -> new BaseException(UserErrorCode.WRONG_ID_OR_PASSWORD));
    }

    @Override
    public UserEntity getUserByUserUuid(String userUuid) {
        return userRepository.findByUserUuid(userUuid)
            .orElseThrow(() -> new BaseException(UserErrorCode.NOT_FOUND_USER));
    }
}
