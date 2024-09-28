package com.zerobase.user.service;

import com.zerobase.user.domain.model.UserEntity;

public interface UserStore {
    UserEntity store(UserEntity users);
}
