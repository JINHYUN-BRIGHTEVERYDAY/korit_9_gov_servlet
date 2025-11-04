package com.example.servlet_study.ch05;

public class ServletB extends Servlet{
    @Override
    public void doGet(Request req, Response res) {
        System.out.println("서블릿 B에서 GET 호출");
    }

    @Override
    public void doPost(Request req, Response res) {
        System.out.println("서블릿 B에서 POST 호출");
    }
}
