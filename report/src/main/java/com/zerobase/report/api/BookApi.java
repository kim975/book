package com.zerobase.report.api;

import com.zerobase.report.report.service.BookInfo;
import java.util.List;

public interface BookApi {

    List<BookInfo.BookApiInfo> findBookList(BookSearchForm bookSearchForm);

    BookInfo.BookApiInfo findBookDetail(BookSearchForm bookSearchForm);

}
