package com.example.servlet_study.ch11;

import com.example.servlet_study.ch11.Service.StudentService;
import com.example.servlet_study.ch11.dao.StudentDao;
import com.example.servlet_study.ch11.dto.StudentDto;
import com.example.servlet_study.ch11.entity.Student;
import com.example.servlet_study.ch11.util.DBConnectionMgr;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 학생 등록
/*

학과 정보 먼저 들고와야

*/

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;
    private ObjectMapper objectMapper;


    @Override
    public void init() throws ServletException {
        studentService = new StudentService(new StudentDao(DBConnectionMgr.getInstance()));
        objectMapper = new ObjectMapper();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDto studentDto = objectMapper.readValue(req.getInputStream(), StudentDto.class);

        // 앞서 서비스 객체 생성하였음
        Student savedStudent = studentService.save(studentDto);
        objectMapper.writeValue(resp.getWriter(), savedStudent);
    }
}
