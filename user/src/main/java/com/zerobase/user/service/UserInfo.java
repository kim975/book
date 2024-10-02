package com.zerobase.user.service;

import com.zerobase.user.domain.model.UserEntity;
import com.zerobase.user.domain.model.UserRole;
import com.zerobase.user.security.UserSecurity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfo {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class SignInInfo implements UserSecurity, UserDetails {
        private String nickname;
        private String userUuid;
        private List<UserRole> userRoles;

        public static UserInfo.SignInInfo fromEntity(UserEntity user) {
            return UserInfo.SignInInfo.builder()
                    .nickname(user.getNickname())
                    .userUuid(user.getUserUuid())
                    .userRoles(user.getUserRoles())
                    .build();
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return userRoles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.toString()))
                    .collect(Collectors.toList());
        }

        @Override
        public String getPassword() {
            return "";
        }

        @Override
        public String getUsername() {
            return userUuid;
        }
    }
}
