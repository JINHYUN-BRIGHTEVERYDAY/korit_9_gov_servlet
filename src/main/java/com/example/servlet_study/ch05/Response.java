package com.example.servlet_study.ch05;


import lombok.Data;


// 응답 클래스
@Data
public class Response {
    private int status;
    private String characterEncoding;
    private String contentType;
    private String data;
}
