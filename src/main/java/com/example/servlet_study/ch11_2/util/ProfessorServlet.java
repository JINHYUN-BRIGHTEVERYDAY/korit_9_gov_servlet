package com.example.servlet_study.ch11_2.util;


import com.example.servlet_study.ch11.util.DBConnectionMgr;
import com.example.servlet_study.ch11_2.dao.ProfessorDao;
import com.example.servlet_study.ch11_2.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("(/professors)")
public class ProfessorServlet extends HttpServlet {
    private Service service;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
//        service = new Service(new ProfessorDao(DBConnectionMgr.getInstance()));
        objectMapper = new ObjectMapper();
    }
}
