package com.zerobase.user.domain.repository;

import com.zerobase.user.domain.model.UserEntity;
import com.zerobase.user.service.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

    private final UserRepository userRepository;

    @Override
    public UserEntity store(UserEntity users) {
        return userRepository.save(users);
    }
}
