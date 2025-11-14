package com.example.servlet_study.ch11_1.entity;


import lombok.Builder;
import lombok.Data;


// Entity 역할 수행
@Data
@Builder
public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private int professorId;
    private int credit;
    private int enrollmentCapacity;
    private String classroom;
}


