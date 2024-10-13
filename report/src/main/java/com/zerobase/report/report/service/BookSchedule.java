package com.zerobase.report.report.service;

import com.zerobase.report.api.BookApi;
import com.zerobase.report.api.BookSearchForm;
import com.zerobase.report.exception.ApiException;
import com.zerobase.report.report.domain.model.BookEntity;
import com.zerobase.report.report.domain.repository.BookReader;
import com.zerobase.report.report.domain.repository.BookStore;
import com.zerobase.report.report.service.BookInfo.BookApiDetail;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookSchedule {

    private final BookReader bookReader;
    private final BookStore bookStore;
    private final BookApi bookApi;

    @Scheduled(cron = "0 45 1 * * *")
    @Transactional
    public void syncBookSchedule() {
        List<BookEntity> allBook = bookReader.getAllBook();

        for (BookEntity book : allBook) {

            String isbn = book.getIsbn();
            BookApiDetail bookDetail;
            try {
                bookDetail = bookApi.findBookDetail(BookSearchForm.builder()
                    .dIsbn(isbn)
                    .build());

            } catch (ApiException e) {
                log.error(String.format("isbn=%s error=%s", isbn, e.getMessage()));
                continue;
            }

            book.setAuthor(bookDetail.getAuthor());
            book.setTitle(bookDetail.getTitle());
            book.setPublisher(bookDetail.getPublisher());
            book.setPublishedDate(bookDetail.getPublishedDate());
            book.setThumbnailImageUrl(bookDetail.getThumbnailImageUrl());

        }

    }

}
