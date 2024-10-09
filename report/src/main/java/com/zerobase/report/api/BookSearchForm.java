package com.zerobase.report.api;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BookSearchForm {

    private String query;
    @Builder.Default private int display = 100; //max 100
    @Builder.Default private int start = 1; //max 100
    @Builder.Default private String sort = "sim"; // sim/date
    private String dTitle;
    private String dIsbn;

    public String makeQueryParam() {

        StringBuilder sb = new StringBuilder();

        if (query != null) {
            try {
                sb.append("query=").append(URLEncoder.encode(query, "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        sb.append("display=").append(display).append("&");
        sb.append("start=").append(start).append("&");
        sb.append("sort=").append(sort).append("&");

        if (dTitle != null) {
            try {
                sb.append("d_titl=").append(URLEncoder.encode(dTitle, "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        if (dIsbn != null) {
            sb.append("d_isbn=").append(dIsbn).append("&");
        }

        return sb.toString();
    }

}
