package com.zerobase.report.api.naver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerobase.report.api.BookApi;
import com.zerobase.report.api.BookSearchForm;
import com.zerobase.report.exception.ApiErrorCode;
import com.zerobase.report.exception.ApiException;
import com.zerobase.report.report.service.BookInfo;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverBookApi implements BookApi {

    @Value(value = "${naverClientId}")
    private String naverClientId;

    @Value(value = "${naverClientSecret}")
    private String naverClientSecret;

    private final ObjectMapper objectMapper;

    @Override
    public List<BookInfo.BookApiInfo> findBookList(BookSearchForm bookSearchForm) {
        return searchBook(bookSearchForm, "https://openapi.naver.com/v1/search/book.json?");
    }

    @Override
    public BookInfo.BookApiInfo findBookDetail(BookSearchForm bookSearchForm) {

        List<BookInfo.BookApiInfo> bookInfoList = searchBook(bookSearchForm, "https://openapi.naver.com/v1/search/book_adv.json?");

        if (bookInfoList.isEmpty()) {
            throw new ApiException(ApiErrorCode.NOT_FOUND_BOOK);
        }

        if (bookInfoList.size() >= 2) {
            throw new ApiException(ApiErrorCode.IS_NOT_UNIQUE);
        }

        return bookInfoList.get(0);
    }

    private List<BookInfo.BookApiInfo> searchBook(BookSearchForm bookSearchForm, String url) {

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + bookSearchForm.makeQueryParam()))
            .setHeader("X-Naver-Client-Id", naverClientId)
            .setHeader("X-Naver-Client-Secret", naverClientSecret)
            .setHeader("Content-Type", "application/json")
            .GET()
            .timeout(Duration.ofSeconds(10))
            .build();

        try (HttpClient httpClient = HttpClient.newHttpClient()) {

            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            String body = response.body();

            NaverBookResponse naverBookResponse = objectMapper.readValue(body, NaverBookResponse.class);

            return naverBookResponse.toBookApiInfo();
        } catch (IOException e) {
            throw new ApiException(ApiErrorCode.COMMON_API_ERROR);
        } catch (InterruptedException e) {
            throw new ApiException(ApiErrorCode.COMMON_API_ERROR);
        }

    }

}
