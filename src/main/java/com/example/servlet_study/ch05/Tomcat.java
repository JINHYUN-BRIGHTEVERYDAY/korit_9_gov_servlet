package com.example.servlet_study.ch05;

import java.util.List;
import java.util.Map;

public class Tomcat {
    public static void main(String[] args) {
        System.out.println("요청");

        // Request 객체 생성
        Request request = new Request();

        // Response 객체 생성
        Response response = new Response();


        // request에 대한 set
        request.setUrl("/servlet/a");
        request.setMethod("GET");
        request.setData("요청 테스트 데이터");

        // ServletA servletA = new ServletA();
        // ServletB servletB = new ServletB();


        // Map 형태로
        Map<String, Servlet> servletMap = Map.of(
                // servletA와 servletB에 대한 객체 생성된 것에 대하여 Map의 key와 Value값을 집어넣기
                // key 값은 set한 url이 들어가야함
                "/servlet/a", new ServletA(),
                "/serlvet/b", new ServletB()
        );


        // filters는 Filter들의 집합
        // Filter는 클래스로 선언되어 있음 -> 객체 생성


        /*

        Filter1 filter1 = new  Filter1();
        Filter2 filter2 = new  Filter2();
        Filter3 filter3 = new  Filter3();

        */

        List<Filter> filters = List.of(
                new Filter1(),
                new Filter2(),
                new Filter3()
        );

        // FilterChain에 대한 객체 생성
        FilterChain filterChain
                = new FilterChain(filters, servletMap.get(request.getUrl()), 0);


        // doFilter
        filterChain.doFilter(request, response);

//        switch (request.getMethod()) {
//            case "GET":
//                servletMap.get(request.getUrl()).doGet(request, response);
//                break;
//            case "POST":
//                servletMap.get(request.getUrl()).doPost(request, response);
//                break;
//        }

        System.out.println(response);
        System.out.println("응답");

    }/**/

}
