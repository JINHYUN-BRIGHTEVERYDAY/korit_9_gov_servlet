package com.example.servlet_study.ch08;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



@Data
@WebServlet("/ch08/boardconfirm")
public class BoardServlet extends HttpServlet {

    List<Board> boards = (List<Board>) mapper.readValue(json, List.class);
    // 1. doPost 메소드에 실행 로직 추가
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 실제 서블릿이라면 여기서 요청을 처리하고 응답을 보냅니다.
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().println("BoardServlet의 doPost() 메소드가 호출되었습니다.");
        System.out.println("서블릿이 요청을 처리 중입니다: POST ch08/boardconfirm");
        // super.doPost(req, resp); // 이 라인은 보통 제거하고 실제 로직을 작성합니다.

        // BufferedReader 필요
//        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream())); 불필요한 코드
        BufferedReader br = req.getReader();
//        br.readLine(); // 한줄씩 가져오기

        String json = "";

        while(true) {
            String str = br.readLine();
            if (str == null)
                break;
            // json 문자열에 추가해야
            json += str;
        }
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(json, Board.class);

        Board.class.toString();



//        List<Board> boards = new ArrayList<>().add();

        Response resp2 = new Response();
        resp2.getMessage();
        resp.getWriter().println();

        resp.setContentType("application/json");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        resp.setContentType("application/json");

        ObjectMapper om2 = new ObjectMapper();
        om2.writeValue(resp.getWriter(), boards);
    }
}