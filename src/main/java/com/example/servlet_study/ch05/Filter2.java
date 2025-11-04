package com.example.servlet_study.ch05;

public class Filter2 implements Filter {

    @Override
    public void doFilter(Request req, Response resp, FilterChain filterChain) {
        System.out.println("필터2 전처리");
        filterChain.doFilter(req, resp);
        System.out.println("필터2 후처리");
    }
}

/*
    doFilter() 메서드는 파라미터에 filterchain을 가지고 있는데,
    filterchain.doFilter(request, response); 메서드를 호출하게 되면,
    다음 필터가 있으면 필터를 호출하고,
    필터가 없으면 dispatcherServlet을 호출한다.

    만약 이 로직을 호출하지 않으면 다음 단계로 진행되지 않기 때문에,
    특별한 경우를 제외하고 반드시 호출해야한다.
*/