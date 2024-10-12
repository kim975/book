package com.zerobase.report.follow.service;

import com.zerobase.report.follow.domain.model.FollowEntity;
import com.zerobase.report.follow.domain.repository.FollowReader;
import com.zerobase.report.follow.domain.repository.FollowStore;
import com.zerobase.report.follow.service.FollowCommand.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowReader followReader;
    private final FollowStore followStore;

    public void registerFollow(Main command) {
        followStore.store(command.toEntity());
    }

    public void unfollow(Main command) {

        FollowEntity follow = followReader.getFollow(command.getUserId(), command.getFollowUserId());
        followStore.delete(follow);
    }
}
