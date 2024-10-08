package com.zerobase.report.report.application;

import com.zerobase.report.report.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookFacade {

    private final BookService bookService;

}
