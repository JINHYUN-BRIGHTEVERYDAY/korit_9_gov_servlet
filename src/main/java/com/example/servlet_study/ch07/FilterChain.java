package com.example.servlet_study.ch07;

import lombok.AllArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class FilterChain {
    private List<EncodingFilter> filters;
    private BoardServlet servlet;
    private int currentOrder;

    public void doFilter(ServletRequest request, ServletResponse response) {
        if  (currentOrder < filters.size()) {
            filters.get(currentOrder++).doFilter(request, response, this);
            return;
        }

    }
}
