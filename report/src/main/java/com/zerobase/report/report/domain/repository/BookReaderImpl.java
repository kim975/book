package com.zerobase.report.report.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookReaderImpl implements BookReader {

    private final BookRepository bookRepository;
    private final BookReportRepository bookReportRepository;

}
