package com.example.servlet_study.ch11_2.util;


import com.example.servlet_study.ch11_2.Service.ProfessorService;
import com.example.servlet_study.ch11_2.entity.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


// 톰캣이 웹을 찾아갈 수 있게끔
@WebServlet("/professors")
public class ProfessorServlet extends HttpServlet {
    private ProfessorService professorService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
//        service = new Service(new ProfessorDao(DBConnectionMgr.getInstance()));
        objectMapper = new ObjectMapper();
    }


    // get 요청이므로
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // q param 뽑아내기 -> 변수에 넣어두기

        // q = "박"
        String q = req.getParameter("q");

        ProfessorService professorService = new ProfessorService();
        List<Professor> professors = professorService.getProfessors(q);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), professors);


    }
}
