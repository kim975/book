package com.zerobase.user.security;

import com.zerobase.user.domain.model.UserRole;

import java.util.List;

public interface UserSecurity {

    String getUserUuid();

    List<UserRole> getUserRoles();

}
