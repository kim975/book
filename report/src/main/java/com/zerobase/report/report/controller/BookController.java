package com.zerobase.report.report.controller;

import com.zerobase.report.common.response.CommonResponse;
import com.zerobase.report.report.application.BookFacade;
import com.zerobase.report.report.controller.BookDto.BookSearchResponse;
import com.zerobase.report.report.service.BookInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookFacade bookFacade;

    @GetMapping("/books")
    public CommonResponse<List<BookDto.BookSearchResponse>> findBook(
        @RequestParam String bookTitle,
        @RequestParam(defaultValue = "false") boolean onlyApi
    ) {

        List<BookInfo.Main> bookListOnlyApi;

        if (onlyApi) {
            bookListOnlyApi = bookFacade.findBookListOnlyApi(bookTitle);
        } else {
            bookListOnlyApi = bookFacade.findBookList(bookTitle);
        }

        return CommonResponse.success(
            bookListOnlyApi.stream()
                .map(BookSearchResponse::fromBookInfo)
                .collect(Collectors.toList())
        );
    }

    @PostMapping("/book")
    public CommonResponse<BookDto.RegisterBookResponse> registerBook(
        @RequestBody BookDto.RegisterBookRequest request
    ) {

        return CommonResponse.success(
            BookDto.RegisterBookResponse.from(bookFacade.registerBook(request.getIsbn()))
        );
    }

}
