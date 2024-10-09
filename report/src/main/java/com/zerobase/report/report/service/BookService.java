package com.zerobase.report.report.service;

import com.zerobase.report.report.domain.repository.BookReader;
import com.zerobase.report.report.domain.repository.BookStore;
import com.zerobase.report.report.service.BookCommand.RegisterBook;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookReader bookReader;
    private final BookStore bookStore;

    public List<BookInfo.Main> getBookList(String title) {
        return bookReader.getBookListByTitle(title).stream()
            .map(BookInfo.Main::fromEntity)
            .collect(Collectors.toList());
    }

    public BookInfo.Main getBookByIsbn(String isbn) {
        return BookInfo.Main.fromEntity(bookReader.getBookByIsbn(isbn));
    }

    public boolean isExistsBook(String isbn) {
        return bookReader.isExistsBookByIsbn(isbn);
    }

    public BookInfo.Main registerBook(RegisterBook registerBook) {
        return BookInfo.Main.fromEntity(bookStore.store(registerBook.toEntity()));
    }
}
