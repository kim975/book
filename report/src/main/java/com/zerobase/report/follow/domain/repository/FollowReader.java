package com.zerobase.report.follow.domain.repository;

import com.zerobase.report.follow.domain.model.FollowEntity;

public interface FollowReader {

    FollowEntity getFollow(Long userId, Long followUserId);
}
