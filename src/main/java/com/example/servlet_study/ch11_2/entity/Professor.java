package com.example.servlet_study.ch11_2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    private int professorId;
    private String professorName;
}


// DB는 대소문자 구분 X, 일반적 코드는 대소문자구분