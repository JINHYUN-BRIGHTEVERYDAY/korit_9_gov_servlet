package com.example.servlet_study.ch05;

import javax.servlet.ServletException;
import java.io.IOException;

public interface Filter {
    void doFilter(Request req, Response resp, FilterChain filterChain);

}
