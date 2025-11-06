package com.example.servlet_study.ch09;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
//    private String characterEncoding;
//    private String contentType;
//    private String resp;
    private String message;

    Response response = new Response();


}
