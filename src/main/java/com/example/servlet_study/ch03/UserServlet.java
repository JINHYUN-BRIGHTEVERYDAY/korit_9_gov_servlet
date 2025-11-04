package com.example.servlet_study.ch03;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@WebServlet("/ch03/users")
public class UserServlet extends HttpServlet {
    private UserRepository userRepository;

    // ObjectMapper 사용
    private ObjectMapper objectMapper;



    // init() : 필터 초기화 메서드, 서블릿 컨테이너가 생성될 때 호출된다.
    @Override
    public void init() throws ServletException {
//        super.init();
        userRepository = UserRepository.getInstance();
        objectMapper = new ObjectMapper();
    }


    /*
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


    // doGet 메서드
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글로 변환
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        // json 형식으로
        resp.setContentType("application/json");
        List<User> users = userRepository.findAll();
        objectMapper.writeValue(resp.getWriter(), users);
    }


    // doPost 메서드
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 한글로 변환
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());


/*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuilder builder = new StringBuilder();

        while (true) {
            String line = bufferedReader.readLine();
            if (Objects.isNull(line)) {
                break;
            }
            builder.append(line);
        }
        UserDto userDto1 = objectMapper.readValue(builder.toString(), UserDto.class);
*/


        // UserDto 객체를 매핑하여 읽을 수 있게끔 변환하기
        UserDto userDto = objectMapper.readValue(req.getReader(), UserDto.class);
        System.out.println(userDto);


        // User 객체 foundUser
        User foundUser = userRepository.findByUsername(userDto.getUsername());

        // 응답 데이터 한글 변환
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        // 응답 데이터 json 형식으로
        resp.setContentType("application/json"); // 포스트맨이 json으로 인식하고 변환
        // {"status":200,"message":"사용자 등록을 완료하였습니다","body":{"id":0,"username":"test","password":"1234","name":"김준일","email":"test@gmail.com"}}




        // 정상적이지 않은 상황에 대한 에러메시지 부여하기
        // foundUser로 찾아낸 데이터가 이미 존재하는 경우
        if (!Objects.isNull(foundUser)) {
            // Builder 패턴 사용
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(400) //builder에게 상태를 주는 것
                    .message("이미 존재하는 username입니다.")
                    .build();
            resp.setStatus(400);


            objectMapper.writeValue(resp.getWriter(), errorResponse);
            return;
        }


        User userEntity = userDto.toUSer();
        userRepository.insert(userDto.toUSer());


        // 사용자 등록이 정상적으로 이루어진 경우

        // SuccessResponse는 제네릭타입을 받고 있었음
        SuccessResponse<User> successResponse = SuccessResponse.<User> builder()
                .status(200)
                .message("사용자 등록을 완료하였습니다")
                .body(userEntity)
                .build();

        objectMapper.writeValue(resp.getWriter(), successResponse);

    }



}
