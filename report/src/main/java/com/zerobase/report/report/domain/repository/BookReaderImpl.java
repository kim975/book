package com.zerobase.report.report.domain.repository;

import com.zerobase.report.exception.BaseException;
import com.zerobase.report.exception.BookErrorCode;
import com.zerobase.report.report.domain.model.BookEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookReaderImpl implements BookReader {

    private final BookRepository bookRepository;
    private final BookReportRepository bookReportRepository;

    @Override
    public List<BookEntity> getBookListByTitle(String title) {
        return bookRepository.findAllByTitleContainingIgnoreCase(title);
    }

    @Override
    public boolean isExistsBookByIsbn(String isbn) {
        return bookRepository.existsByIsbn(isbn);
    }

    @Override
    public BookEntity getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BaseException(BookErrorCode.NOT_FOUND_BOOK));
    }
}
