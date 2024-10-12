package com.zerobase.report.api.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class UserApi {

    private final RestTemplate restTemplate;

    public UserApiDto.UserDetail getUser(String query, UserSearchType searchType) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host("localhost")
            .port(8080)
            .path("/internal/api/v1/user")
            .queryParam("query", query)
            .queryParam("searchType", searchType.getSearchType());

        return restTemplate.getForObject(uriComponentsBuilder.build().toString(), UserApiDto.UserDetail.class);
    }

    public UserApiDto.UserDetailList getUsers(List<String> query, UserSearchType searchType) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host("localhost")
            .port(8080)
            .path("/internal/api/v1/users")
            .queryParam("query", query)
            .queryParam("searchType", searchType.getSearchType());

        return restTemplate.getForObject(uriComponentsBuilder.build().toString(), UserApiDto.UserDetailList.class);
    }

}
