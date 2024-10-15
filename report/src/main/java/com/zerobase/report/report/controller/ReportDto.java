package com.zerobase.report.report.controller;

import com.zerobase.report.report.application.BookFacadeDto;
import com.zerobase.report.report.service.BookInfo;
import com.zerobase.report.report.service.ReportInfo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ReportDto {

    @Getter
    @Setter
    @Builder
    @ToString
    public static class ReportDetailResponse {

        private ReportDto.Book book;
        private Long bookReportSeq;
        private LocalDateTime readDateTime;
        private String text;
        private Boolean reveal;
        private String userNickname;

        public static ReportDto.CreateReportResponse from(ReportInfo.Main report) {
            return CreateReportResponse.builder()
                .book(Book.from(report.getBook()))
                .bookReportSeq(report.getBookReportSeq())
                .readDateTime(report.getReadDateTime())
                .text(report.getText())
                .reveal(report.getReveal())
                .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class CreateReportRequest {

        private Long bookId;
        private LocalDateTime readDatetime; //yyyy-MM-ddTHH:mm:ss
        private String text;
        private Boolean reveal;

        public BookFacadeDto.CreateReportRequest toFacadeDto(String userUuid) {
            return BookFacadeDto.CreateReportRequest.builder()
                .bookId(bookId)
                .userUuid(userUuid)
                .readDatetime(readDatetime)
                .text(text)
                .reveal(reveal)
                .build();
        }

    }

    @Getter
    @Setter
    @Builder
    @ToString
    public static class CreateReportResponse {

        private ReportDto.Book book;
        private Long bookReportSeq;
        private LocalDateTime readDateTime;
        private String text;
        private Boolean reveal;

        public static ReportDto.CreateReportResponse from(ReportInfo.Main report) {
            return CreateReportResponse.builder()
                .book(Book.from(report.getBook()))
                .bookReportSeq(report.getBookReportSeq())
                .readDateTime(report.getReadDateTime())
                .text(report.getText())
                .reveal(report.getReveal())
                .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @ToString
    private static class Book {

        private Long id;
        private String title;
        private String author;
        private String publisher;
        private String isbn;
        private String thumbnailImageUrl;
        private LocalDate publishedDate;

        public static ReportDto.Book from(BookInfo.Main bookInfo) {
            return ReportDto.Book.builder()
                .id(bookInfo.getId())
                .title(bookInfo.getTitle())
                .author(bookInfo.getAuthor())
                .publisher(bookInfo.getPublisher())
                .isbn(bookInfo.getIsbn())
                .thumbnailImageUrl(bookInfo.getThumbnailImageUrl())
                .publishedDate(bookInfo.getPublishedDate())
                .build();
        }
    }

}
