package com.example.servlet_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/study/students2")
public class StudentServlet extends HttpServlet {
//    private List<Student> students = new ArrayList<>();
//    private StudentRepository studentRepository = new StudentRepository();
    private ObjectMapper om = new ObjectMapper();
    private StudentRepository studentRepository;
//    private int autoId = 2025001;


    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = new StudentRepository();
        config.getServletContext().setAttribute("sr", studentRepository);
        System.out.println(config.getServletContext().getAttribute("sr"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setContentType("application/json");
        String searchNameValue = req.getParameter("searchName");
        om.writeValue(resp.getWriter(), studentRepository.findAllBySearchNameValue(searchNameValue));


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding(StandardCharsets.UTF_8.name()); // 한글 깨짐 방지
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setContentType("application/json");
        Student student = om.readValue(req.getReader(), Student.class);
//        student.setId(autoId++);
//        students.add(student);
        studentRepository.insert(student);
        om.writeValue(resp.getWriter(), Map.of("message", "학생 추가 완료")); // Map을 json으로 변환
//        om.writeValue(resp.getWriter(), students.add(new Student()));
//        Student student = om.readValue(req.getReader(), Student.class); // 스트림으로부터 읽어서 값을 변환
//        om.writeValue(resp.getWriter(), Student.class);
    }

}
