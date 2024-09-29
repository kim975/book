package com.zerobase.user.domain.repository;

import com.zerobase.user.domain.model.UserEntity;

public interface UserStore {
    UserEntity store(UserEntity users);
}
