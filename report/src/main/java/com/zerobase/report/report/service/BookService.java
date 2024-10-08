package com.zerobase.report.report.service;

import com.zerobase.report.report.domain.repository.BookReader;
import com.zerobase.report.report.domain.repository.BookStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookReader bookReader;
    private final BookStore bookStore;

}
