package com.zerobase.report.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class UserApi {

    private final RestTemplate restTemplate;

    public UserApiDto getUser(String userUuid) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host("localhost")
            .port(8080)
            .path("/internal/api/v1/user/" + userUuid);

        return restTemplate.getForObject(uriComponentsBuilder.build().toString(), UserApiDto.class);
    }

}
