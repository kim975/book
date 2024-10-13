package com.zerobase.report.report.domain.repository;

import com.zerobase.report.exception.BaseException;
import com.zerobase.report.exception.BookErrorCode;
import com.zerobase.report.report.domain.model.BookEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<BookEntity> getBookListByTitleWithPage(String title, Pageable pageable) {
        Page<BookEntity> allByTitleContainingIgnoreCase = bookRepository.findAllByTitleContainingIgnoreCase(title, pageable);
        return allByTitleContainingIgnoreCase;
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
