package com.example.servlet_study.ch11.Service;

import com.example.servlet_study.ch11.dao.StudentDao;
import com.example.servlet_study.ch11.dto.StudentDto;
import com.example.servlet_study.ch11.entity.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentService {
    private final StudentDao studentDao;

    public Student save(StudentDto studentDto) {
        /* DTO -> ENTITY
        * 자료형식 맞추기
        * = 인터페이스 맞추기 (F = B)
        */
        Student student = studentDto.toEntity();
        studentDao.insert(student);
        return student;
    }
}
