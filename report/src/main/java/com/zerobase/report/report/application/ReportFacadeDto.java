package com.zerobase.report.report.application;

import com.zerobase.report.report.domain.model.BookEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReportFacadeDto {

    public static class ReportDetailResponse {

        private Long id;
        private BookDetail book;
        private UserDetail user;
        private Long bookReportSeq;
        private LocalDateTime readDateTime;
        private String text;
        private Boolean reveal;
    }

    public static class UserDetail {

        private Long id;
        private String loginId;
        private String name;
        private String nickname;
        private String email;
        private String phoneNumber;
        private String userUuid;
    }

    public static class BookDetail {

        private Long id;
        private String title;
        private String author;
        private String publisher;
        private String isbn;
        private String thumbnailImageUrl;
        private LocalDate publishedDate;
    }

}
