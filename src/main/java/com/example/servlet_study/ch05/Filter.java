package com.example.servlet_study.ch05;

import javax.servlet.ServletException;
import java.io.IOException;

public interface Filter {

    // 추상메서드 doFilter 여기서 FilterChain 객체를 매개변수로 받았다
    void doFilter(Request req, Response resp, FilterChain filterChain);

    /*

     ServletRequest와 ServletResponse 제공함
     필터 인터페이스를 구현하고 등록하면 서블릿 컨테이너가 필터를
     싱글톤 객체로 생성하고 관리

     */



    /*

    필터는 다음의 3가지 메서드로 구성된다.

    init() : 필터 초기화 메서드, 서블릿 컨테이너가 생성될 때 호출된다.

    doFilter() : 고객의 요청이 올 때 마다 해당 메서드가 호출된다.
                 필터의 로직을 구현하면 된다.

    doFilter() 메서드는 파라미터에 filterchain을 가지고 있는데,
    filterchain.doFilter(request, response); 메서드를 호출하게 되면,
    다음 필터가 있으면 필터를 호출하고,
    필터가 없으면 dispatcherServlet을 호출한다.

    만약 이 로직을 호출하지 않으면 다음 단계로 진행되지 않기 때문에,
    특별한 경우를 제외하고 반드시 호출해야한다.


    destroy() : 필터 종료 메서드, 서블릿 컨테이너가 종료될 때 호출된다.


    */
}
