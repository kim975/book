package com.zerobase.report.report.domain.repository;

import com.zerobase.report.report.domain.model.BookEntity;
import com.zerobase.report.report.domain.model.BookReportEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookStoreImpl implements BookStore, ReportStore {

    private final BookRepository bookRepository;
    private final BookReportRepository bookReportRepository;

    @Override
    public BookEntity store(BookEntity entity) {
        return bookRepository.save(entity);
    }

    @Override
    public BookReportEntity store(BookReportEntity report) {
        return bookReportRepository.save(report);
    }
}
