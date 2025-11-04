package com.example.servlet_study.ch02;

/*
* HTTP 프로토콜 Method
*
* 1. Get
*       - 용도 : 리소스 조회
*       - 특징 : 서버로부터 데이터를 요청만 하고 수정하지 않는다
*               요청 데이터(파라미터)가 URL에 포함된다 ex) http://test.com/users?username=test1234
*               브라우저 히스토리에 남는다
*               북마크 기능
*               캐싱 기능
*               멱등성 있음
*
*
*       '멱등성(冪等性)'은 수학, 전산학, 특히 API 등에서 동일한 연산을 여러 번 수행해도 결과가 처음 한 번 수행했을 때와 동일하게 유지되는 성질을 말합니다.
*       이는 네트워크 오류나 중복 요청이 발생했을 때 데이터의 일관성을 보장하는 데 중요한 역할을 하며,
*       GET, PUT, DELETE와 같은 일부 HTTP 메서드는 본질적으로 멱등성을 가지지만,
*       POST는 일반적으로 멱등성을 가지지 않습니다.
*
*
* 2. Post
*       - 용도 : 새로운 리소스 생성
*       - 특징 :
*           서버에 데이터 전송하여 새로운 리소스 생성
*           요청 데이터가 HTTP Body에 포함된다
*           브라우저 히스토리에 남지 않는다
*           캐싱되지 않는다
*
*
* 3. Put
*       - 용도 : 리소스 전체 수정/생성
*       - 특징 :
*           리소스가 있으면 전체를 교체, 없으면 생성하기
*           전체 데이터를 전송해야 한다
*           멱등성 있음
*
*
* 4. Patch
*       - 용도 : 리소스 부분 수정
*       - 특징 :
*           리소스의 일부만 수정
*           Put보다 효율적 (변경할 필드만 전송)
*           멱등성 있음
*
*
* 5. Delete
*       - 용도 : 리소스 삭제
*       - 특징 :
*           지정된 리소스 삭제
*           멱등성 있음
*
*
* 6. HEAD
*       - 용도 : 리소스 존재여부 또는 메타데이터 확인
*
*
* 7. OPTIONS
*       - 용도 : HTTP 메서드의 존재 여부 또는 CORS 프리플라이트 요청에 사용
*
*
* 8. CONNECT
*       - 용도 : 프록시 서버를 통한 터널링에 사용, SSL 연결에 활용됨
*
*
* 9. TRACE
*       - 용도 : 디버깅 시에 사용, 요청 경로 루프백 테스트
*
*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/ch02/method")
public class HttpMethodServlet extends HttpServlet {

    Map<String, String > datas = new HashMap<>(Map.of(
            "name" , "김준일",
            "age" , "32",
            "address" , "동래구"
    ));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청 들어옴");



        /// ///// 요청부
        System.out.println(req.getMethod());
        // 요청 데이터 (파라미터)
        String datasKey = req.getParameter("datasKey");
        System.out.println(datas.get(datasKey));
        /// ///////////////////////////////////////////////////////////////////////////


        // 응답부
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name()); // 문자 인코딩 -> 한글 출력되도록
        PrintWriter out = resp.getWriter();
        out.println(datas.get(datasKey));

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post 요청 들어옴");

        /// ///// 요청부
        System.out.println(req.getMethod());

        // 요청 데이터 (파라미터)
        System.out.println(req.getParameter("textData"));
        datas.put(req.getParameter("keyName"), req.getParameter("value"));

        /// ///////////////////////////////////////////////////////////////////////////
        resp.setStatus(201);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.getWriter().println("데이터 추가 성공!!");
    }
}
