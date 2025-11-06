package com.example.servlet_study.ch09;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.annotation.WebServlet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@WebServlet
public class Request {
//    private String url;
//    private String method;
//    private String data;
    private String characterEncoding;
    private String contentType;

    Request request = new Request();

}
