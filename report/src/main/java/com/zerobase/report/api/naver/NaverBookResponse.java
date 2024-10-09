package com.zerobase.report.api.naver;

import com.zerobase.report.report.service.BookInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverBookResponse {

    private int total;
    private int start;
    private int display;
    private List<NaverBookDetail> items;

    public List<BookInfo.BookApiInfo> toBookApiInfo() {

        return items.stream()
            .map(NaverBookDetail::toBookApiInfo)
            .collect(Collectors.toList());
    }
}
