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

    public static UserRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void insert(User user) {
        user.setId(++autoId);
        users.add(user);
    }

    public User findByUsername(String username) {
//        Optional<User> userOptional = users.stream() // users를 stream 사용
//                .filter(user -> user.getUsername().equals(username)) // filter 돌리기
//                .findFirst()
//
//        return userOptional.orElseGet(() -> null);

        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseGet(() -> null);

    }


    public User findByUsernameNonOptional(String username) {
        List<User> foundUsers = users.stream()
                .filter(user -> user.getUsername().equals(username))
                .toList();
        if (foundUsers.isEmpty()) {
            return null;
        }
        return foundUsers.get(0);

    }

    public List<User> findAll() {
        return users;
    }

}
