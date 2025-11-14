package com.example.servlet_study.ch11_1.dto;

import com.example.servlet_study.ch11_1.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    // 인스턴스 변수
    private String courseCode;
    private String courseName;
    private int professorId;
    private int credit;
    private int enrollmentCapacity;
    private String classRoom;


    // toEntity 메서드 정의하기
    public Course toEntity() {
        return Course.builder()
                .courseCode(courseCode)
                .courseName(courseName)
                .professorId(professorId)
                .credit(credit)
                .enrollmentCapacity(enrollmentCapacity)
                .classroom(classRoom)
                .build();
                //빌더 빌드 사용하여 불러오기
    }

}
