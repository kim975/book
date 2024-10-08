package com.zerobase.report.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NaverBookApi {

    public HttpURLConnection asd() {

        URL url;
        HttpURLConnection conn = null;
        try {
            url = new URL("http://192.168.0.2:9201/twitter/_doc/1");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET"); //Method 방식 설정. GET/POST/DELETE/PUT/HEAD/OPTIONS/TRACE
            conn.setConnectTimeout(5000); //연결제한 시간 설정. 5초 간 연결시도
            conn.setRequestProperty("Content-Type", "application/json");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


}
