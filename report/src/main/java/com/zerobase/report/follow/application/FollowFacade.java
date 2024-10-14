package com.zerobase.report.follow.application;

import com.zerobase.report.api.user.UserApi;
import com.zerobase.report.api.user.UserApiDto;
import com.zerobase.report.api.user.UserApiDto.UserDetailList;
import com.zerobase.report.api.user.UserSearchType;
import com.zerobase.report.follow.application.FollowFacadeDto.MainRequest;
import com.zerobase.report.follow.service.FollowCommand.Main;
import com.zerobase.report.follow.service.FollowService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowFacade {

    private final FollowService followService;
    private final UserApi userApi;

    public void registerFollow(MainRequest dto) {

        UserApiDto.UserDetail user = userApi.getUser(dto.getUserUuid(), UserSearchType.USER_UUID);
        UserApiDto.UserDetail followUser = userApi.getUser(dto.getFollowUserNickName(), UserSearchType.NICKNAME);

        followService.registerFollow(
            Main.builder()
                .userId(user.getData().getId())
                .followUserId(followUser.getData().getId())
                .build()
        );

    }

    public void unfollow(MainRequest dto) {
        UserApiDto.UserDetail user = userApi.getUser(dto.getUserUuid(), UserSearchType.USER_UUID);
        UserApiDto.UserDetail followUser = userApi.getUser(dto.getFollowUserNickName(), UserSearchType.NICKNAME);

        followService.unfollow(
            Main.builder()
                .userId(user.getData().getId())
                .followUserId(followUser.getData().getId())
                .build()
        );
    }
}
