package com.example.servlet_study.ch11_1.service;

import com.example.servlet_study.ch11.dao.StudentDao;
import com.example.servlet_study.ch11.dto.StudentDto;
import com.example.servlet_study.ch11.entity.Student;
import com.example.servlet_study.ch11_1.dao.CourseDao;
import com.example.servlet_study.ch11_1.dto.CourseDto;
import com.example.servlet_study.ch11_1.entity.Course;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseService {
    private final CourseDao courseDao;

    public Course save(CourseDto courseDto) {

        Course course = courseDto.toEntity();
        courseDao.insert(course);
        // courseDao가 문제가 되는 상황
        return course;
    }
}
