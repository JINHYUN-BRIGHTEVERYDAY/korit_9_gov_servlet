package com.example.servlet_study.ch11;

import com.example.servlet_study.ch11.Service.DepartmentService;
import com.example.servlet_study.ch11.dao.DepartmentDao;
import com.example.servlet_study.ch11.entity.Department;
import com.example.servlet_study.ch11.util.DBConnectionMgr;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {
    private DepartmentService departmentService;
    private ObjectMapper objectMapper;

//    public DepartmentServlet() {
//
//    }


    @Override
    public void init() throws ServletException {
        DBConnectionMgr dbConnectionMgr = DBConnectionMgr.getInstance();
        DepartmentDao departmentDao = new DepartmentDao(dbConnectionMgr);
        departmentService = new DepartmentService(departmentDao);
        objectMapper = new ObjectMapper(); // 생성해야 한다
    }

    // 조회가 일어나야함
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 받을 때 파라미터로 받기  ?key = value
        List<Department> departments = departmentService.getDepartments();
        objectMapper.writeValue(resp.getWriter(), departments);
        // 조건 없이 전체 조회하는 상황

    }

}
