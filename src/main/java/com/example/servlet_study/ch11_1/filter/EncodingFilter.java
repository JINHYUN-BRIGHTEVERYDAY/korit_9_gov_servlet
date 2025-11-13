package com.example.servlet_study.ch11_1.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter("/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 요청 데이터를 인코딩하기 위해서
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());

        // 응답 데이터를 인코딩하기 위해서
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        // 응답 데이터 타입 -> json으로
        response.setContentType("application/json");

        // 다음 필터 또는 서블릿으로 체이닝
        chain.doFilter(request, response);

    }
}
