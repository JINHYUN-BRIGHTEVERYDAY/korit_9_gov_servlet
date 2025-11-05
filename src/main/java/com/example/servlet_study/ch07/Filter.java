package com.example.servlet_study.ch07;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface Filter {
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;
}
