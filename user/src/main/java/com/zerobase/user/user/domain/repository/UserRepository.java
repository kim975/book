package com.zerobase.user.user.domain.repository;

import com.zerobase.user.user.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByLoginId(String LoginId);

    Optional<UserEntity> findByLoginIdAndPassword(String LoginId, String password);

    Optional<UserEntity> findByUserUuid(String userUuid);
}
