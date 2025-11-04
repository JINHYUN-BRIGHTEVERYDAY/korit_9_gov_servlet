package com.example.servlet_study.ch01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletConfigTest extends HttpServlet {

    // HttpServlet 에 있는 service 메서드 오버라이드 해서 사용하기
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // HttpServletRequest 객체 req에 getServletContext 메서드, getAttribute 메서드 불러오기
        Object age = req.getServletContext().getAttribute("age");
        System.out.println(age);
    }
}
