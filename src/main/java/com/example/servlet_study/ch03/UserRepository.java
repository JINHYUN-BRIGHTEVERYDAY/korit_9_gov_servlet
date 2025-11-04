package com.example.servlet_study.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {

    // 싱글톤 패턴
    private static UserRepository instance;
    private List<User> users;
    private Long autoId = 0l;

    private UserRepository() {
        users = new ArrayList<>();
    }

    // instance 생성
    public static UserRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UserRepository();
        }
        return instance;
    }


    // User 추가
    public void insert(User user) {

        // user의 Id 세팅하고
        user.setId(++autoId);

        // users라는 리스트에 세팅한 Id인 user를 users 리스트에 추가하기
        users.add(user);

    }


    // Username 찾기
    public User findByUsername(String username) {
//        Optional<User> userOptional = users.stream() // users를 stream 사용
//                .filter(user -> user.getUsername().equals(username)) // filter 돌리기
//                .findFirst()
//
//        return userOptional.orElseGet(() -> null);


        // stream 사용
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                //  처음부터 찾고
                .findFirst()
                // 얻어지는 것이 없으면 -> null
                .orElseGet(() -> null);

    }

    // username을 찾는데 Option이 없음
    public User findByUsernameNonOptional(String username) {
        List<User> foundUsers = users.stream()
                .filter(user -> user.getUsername().equals(username))
                .toList();
        if (foundUsers.isEmpty()) {
            return null;
        }
        return foundUsers.get(0);

    }

    // 다 찾은 User를 리스트에
    public List<User> findAll() {
        return users;
    }

}
