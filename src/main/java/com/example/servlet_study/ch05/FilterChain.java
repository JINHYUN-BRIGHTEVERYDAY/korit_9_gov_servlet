package com.example.servlet_study.ch05;

import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class FilterChain {
    // FilterChain 객체를 위한 멤버변수
    private List<Filter> filters;
    private Servlet servlet;
    private int currentOrder;



    // Filter 호출 시에 필요한 doFilter 메서드
    public void doFilter(Request req, Response resp) {

        // 여기서 filters는 Filter들의 리스트 형태
        if (currentOrder < filters.size()) {

            // get을 받고 Filter 인터페이스에서의 매개변수 다 받아오기
            filters.get(currentOrder++).doFilter(req, resp, this);
            return;
        }



        // 실행할 필터가 없어야 서블릿을 실행
        // 대소문자 구분하지 않고 요청한 메서드와 해당 메서드의 일치 여부를 확인
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            // GET과 일치하면 get 메서드 호출
            servlet.doGet(req, resp);
        } else if ("POST".equalsIgnoreCase(req.getMethod())) {
            // POST와 일치하면 POST 메서드 호출하기
            servlet.doPost(req, resp);
        }

    }

}
