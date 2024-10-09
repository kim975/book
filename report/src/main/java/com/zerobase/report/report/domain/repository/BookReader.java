package com.zerobase.report.report.domain.repository;

import com.zerobase.report.report.domain.model.BookEntity;
import java.util.List;

public interface BookReader {

    List<BookEntity> getBookListByTitle(String title);

    boolean isExistsBookByIsbn(String isbn);

    BookEntity getBookByIsbn(String isbn);
}
