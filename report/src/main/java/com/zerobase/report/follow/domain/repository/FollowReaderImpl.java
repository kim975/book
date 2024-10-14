package com.zerobase.report.follow.domain.repository;

import com.zerobase.report.exception.BaseException;
import com.zerobase.report.exception.FollowErrorCode;
import com.zerobase.report.follow.domain.model.FollowEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FollowReaderImpl implements FollowReader {

    private final FollowRepository followRepository;

    @Override
    public FollowEntity getFollow(Long userId, Long followUserId) {
        return followRepository.findByUserIdAndFollowUserId(userId, followUserId).orElseThrow(() -> new BaseException(FollowErrorCode.NOT_FOUND_FOLLOW));
    }

    @Override
    public boolean isFollowed(Long userId, Long followUserId) {
        return followRepository.findByUserIdAndFollowUserId(userId, followUserId).isPresent();
    }
}
