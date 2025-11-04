package com.example.servlet_study.ch05;

public class ServletB extends Servlet{
    @Override
    public void doGet(Request req, Response resp) {
        // 서블릿 B에서 GET으로 메서드 호출하였음을 알림
        System.out.println("서블릿 A에서 GET 호출");
        // 상태 코드
        resp.setStatus(200);
        // json 타입으로 변환
        resp.setContentType("application/json");
        // 한글 변환
        resp.setCharacterEncoding("UTF-8");
        // 응답 데이터로 set
        resp.setData("응답데이터");

    }

    @Override
    public void doPost(Request req, Response resp) {
        System.out.println("서블릿 B에서 POST 호출");
    }
}
