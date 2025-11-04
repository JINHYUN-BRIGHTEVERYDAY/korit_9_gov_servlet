package com.example.servlet_study.ch02;


//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;



//@WebServlet("/ch02/users")
//public class UserServlet extends HttpServlet {
//    private List<User> users;
//
//
//    // 1. 서블릿 초기화 시 List<User> 객체 생성
//    @Override
//    public void init() throws ServletException {
//        users = new ArrayList<>();
//        System.out.println("UserServlet 초기화 완료. 사용자 리스트 생성됨.");
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("사용자등록 Post 요청 시도");
//
//
//
//        // **한글 깨짐 방지**: POST 요청의 경우, 파라미터 읽기 전에 인코딩 설정이 필수
//        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//
//        // 요청 데이터 (파라미터) 읽기
//        String user = req.getParameter("user");       // key: user
//        String password = req.getParameter("password"); // key: password
//        String username = req.getParameter("name");         // key: name
//        String email = req.getParameter("email");       // key: email
//
//
//        // 읽은 데이터로 User 객체 생성
//        User newUser = new User(user, password, username, email);
//
//
//        // 내지는 빌더 패턴으로
//        // 다른 방법으로는 setter 사용하여
//
//
//        // 생성된 User 객체를 리스트에 추가
//        users.add(newUser);
//
//
//        // 로그 출력 (확인용)
//        System.out.println("새로운 사용자 등록 성공: " + newUser.toString());
//        System.out.println("현재 등록된 사용자 수: " + users.size());
//
//
//        // 응답 설정
//        resp.setStatus(HttpServletResponse.SC_OK); // HTTP 200 (성공)
//        resp.setContentType("text/plain");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//
//        // 클라이언트에게 성공 메시지 전송
//        resp.getWriter().println(user + " 님의 데이터 추가 성공!! (총 " + users.size() + "명)");
//
//
//    }
//
//    // 테스트를 위해 GET 요청도 추가
//
//    // 찾으면  User 객체 응답 (200), 못 찾게 되면 해당 username은 존재하지 않습니다 (400) 출력
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.setContentType("text/plain");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//        resp.getWriter().println("현재 등록된 사용자 목록:");
//            for (User user : users) {
//                resp.getWriter().println( user.getName() + "(" + user.getUsername() + ")" + " - " + user.getEmail() + " (" + user.getPassword() + ")");
//            }
//    }

//}
    // 요청부


    /*
    *
    * @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post 요청 들어옴");

        /// ///// 요청부
        System.out.println(req.getMethod());

        // 요청 데이터 (파라미터)
        System.out.println(req.getParameter("textData"));
        datas.put(req.getParameter("keyName"), req.getParameter("value"));

        /// ///////////////////////////////////////////////////////////////////////////
        resp.setStatus(201);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.getWriter().println("데이터 추가 성공!!");
    }*/


/*
*
* key : user , value: test
* key : password, vale : 1234
* name : 김준일
* email : test@gmail.com
* */
