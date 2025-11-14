package com.example.servlet_study.ch11_1.util;


import com.example.servlet_study.ch11.util.DBConnectionMgr;
import com.example.servlet_study.ch11_1.dao.CourseDao;
import com.example.servlet_study.ch11_1.dto.CourseDto;
import com.example.servlet_study.ch11_1.entity.Course;
import com.example.servlet_study.ch11_1.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    private CourseService courseService;
    private ObjectMapper objectMapper;


    @Override
    public void init() throws ServletException {
        courseService = new CourseService(new CourseDao(DBConnectionMgr.getInstance()));
        objectMapper = new ObjectMapper();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDto courseDto = objectMapper.readValue(req.getInputStream(), CourseDto.class);


        // 앞서 서비스 객체 생성하였음
        Course savedCourse = courseService.save(courseDto);
        objectMapper.writeValue(resp.getWriter(), savedCourse);


    }
}
