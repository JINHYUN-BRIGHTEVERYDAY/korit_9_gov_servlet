package com.example.servlet_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/study/study")
public class StudyServlet extends HttpServlet {
    private ObjectMapper om = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("sr");

        om.writeValue(resp.getWriter(), studentRepository.findAllBySearchNameValue(null));

    }

}
