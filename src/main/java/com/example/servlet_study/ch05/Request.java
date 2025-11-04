package com.example.servlet_study.ch05;

import lombok.Data;


// 요청 클래스
@Data
public class Request {
    private String url;
    private String method;
    private String data;
}
