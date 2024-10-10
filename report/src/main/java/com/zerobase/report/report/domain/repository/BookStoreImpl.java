package com.zerobase.report.report.domain.repository;

import com.zerobase.report.report.domain.model.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookStoreImpl implements BookStore {

    private final BookRepository bookRepository;

    @Override
    public BookEntity store(BookEntity entity) {
        return bookRepository.save(entity);
    }
}
