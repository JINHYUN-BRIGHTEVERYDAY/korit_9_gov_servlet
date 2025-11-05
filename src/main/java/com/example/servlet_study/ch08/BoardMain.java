package com.example.servlet_study.ch08;


public class BoardMain {
    public static void main(String[] args) {
        System.out.println("--- 서블릿 가상 실행 시작 ---");
        try {
            System.out.println("서버 없이 서블릿의 메소드를 직접 호출할 수 없습니다.");
            System.out.println("실제 서블릿 실행을 위해서는 반드시 웹 서버(Tomcat)가 필요합니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--- 서블릿 가상 실행 종료 ---");
    }
}
