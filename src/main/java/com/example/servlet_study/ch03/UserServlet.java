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
    private ObjectMapper objectMapper;


    @Override
    public void init() throws ServletException {
//        super.init();
        userRepository = UserRepository.getInstance();
        objectMapper = new ObjectMapper();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");
        List<User> users = userRepository.findAll();
        objectMapper.writeValue(resp.getWriter(), users);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
//        StringBuilder builder = new StringBuilder();
//
//        while (true) {
//            String line = bufferedReader.readLine();
//            if (Objects.isNull(line)) {
//                break;
//            }
//            builder.append(line);
//        }
//        UserDto userDto1 = objectMapper.readValue(builder.toString(), UserDto.class);


        UserDto userDto = objectMapper.readValue(req.getReader(), UserDto.class);
        System.out.println(userDto);

        User foundUser = userRepository.findByUsername(userDto.getUsername());

        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json"); // 포스트맨이 json으로 인식하고 변환
        // {"status":200,"message":"사용자 등록을 완료하였습니다","body":{"id":0,"username":"test","password":"1234","name":"김준일","email":"test@gmail.com"}}


        if (!Objects.isNull(foundUser)) {
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

        SuccessResponse<User> successResponse = SuccessResponse.<User> builder()
                .status(200)
                .message("사용자 등록을 완료하였습니다")
                .body(userEntity)
                .build();

        objectMapper.writeValue(resp.getWriter(), successResponse);

    }



}
