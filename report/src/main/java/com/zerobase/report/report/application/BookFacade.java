package com.zerobase.report.report.application;

import com.zerobase.report.api.BookApi;
import com.zerobase.report.api.BookSearchForm;
import com.zerobase.report.report.service.BookCommand;
import com.zerobase.report.report.service.BookCommand.RegisterBook;
import com.zerobase.report.report.service.BookInfo;
import com.zerobase.report.report.service.BookInfo.BookApiInfo;
import com.zerobase.report.report.service.BookInfo.Main;
import com.zerobase.report.report.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookFacade {

    private final BookService bookService;
    private final BookApi bookApi;

    public List<BookInfo.Main> findBookList(String bookTitle) {

        List<BookInfo.Main> bookListDb = bookService.getBookList(bookTitle);

        if (!bookListDb.isEmpty()) {
            return bookListDb;
        }

        return bookApi.findBookList(
                BookSearchForm.builder()
                    .query(bookTitle)
                    .build()
            )
            .stream()
            .map(BookInfo.BookApiInfo::toMain)
            .toList();
    }

    public List<BookInfo.Main> findBookListOnlyApi(String bookTitle) {
        return bookApi.findBookList(
                BookSearchForm.builder()
                    .query(bookTitle)
                    .build()
            )
            .stream()
            .map(BookInfo.BookApiInfo::toMain)
            .toList();

    }

    public BookInfo.Main registerBook(String isbn) {
        if (!bookService.isExistsBook(isbn)) {

            BookApiInfo bookApiInfo = bookApi.findBookDetail(
                BookSearchForm.builder()
                    .dIsbn(isbn)
                    .build()
            );

            return bookService.registerBook(RegisterBook.fromBookInfo(bookApiInfo));

            //TODO order 도메인에 상품 정보 등록하기
        } else {
            return bookService.getBookByIsbn(isbn);
        }

    }
}
