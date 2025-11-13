package com.example.servlet_study.ch11_2.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Professor {
    private int professorId;
    private String professorName;
}
