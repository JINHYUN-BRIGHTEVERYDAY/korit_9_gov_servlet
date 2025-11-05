package com.example.servlet_study.ch06;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalMain {
//    public static void main(String[] args) {
////        Optional<String> stringOptional1 = new Optional
//        // Optional 생성
//        Optional<String> stringOptional1 = Optional.empty();
//        Optional<String> stringOptional2 = Optional.of("데이터"); // null 불가능
//        Optional<String> stringOptional3 = Optional.ofNullable(null); // null 가능
//
//
//
//        // flag에 따른 op 출력
//        boolean flag = false;
//        Optional<String> op = Optional.ofNullable(flag ? "데이터1" : null);
//        System.out.println(op);
//        // 출력되지 못한다
//        // System.out.println(op.get());
//
//        System.out.println(op.orElseGet(() -> null));
//
//
//        // flag에 따른 op 출력
//        boolean flag2 = true;
//        Optional<String> op2 = Optional.ofNullable(flag2 ? "데이터2" : null);
//        System.out.println(op2);
//        System.out.println(op.orElse("데이터3")); // 대체될 수 있는 값
//
//        // optional에서 값 가져오기
//        System.out.println(op2.get());
//
//
//        /*
//        System.out.println(op2.orElseGet(()->null));
//        System.out.println(op2.orElseGet(()->"데이터2"));
//        */
//
//
//        // 조건부로 값 가져오기 -> 비었는지, 값이 있는지
//        System.out.println(op.isEmpty());
//        System.out.println(op.isPresent());
//        if (op.isPresent()) {
//            System.out.println(op.get());
//        } else {
//            System.out.println("null");
//        }
//
//
//        System.out.println(op2.isEmpty());
//        System.out.println(op2.isPresent());
//        if (op2.isPresent()) {
//            System.out.println(op2.get());
//        } else {
//            System.out.println("null");
//        }
//
//
//        // 조건부 + Optional
//        // consumer 함수 -> return이 없다 (다 소비하기 때문에)
//        op.ifPresent(value -> System.out.println("값이 있으면" + value));
//        op.ifPresentOrElse(
//                value -> System.out.println("값이 있으면" + value),
//                        () -> System.out.println("값이 없어서 이거 실행됨")
//        );
//
//
//        // 예외처리 -> 스프링부트
//        try {
//            String data = op.orElseThrow();
//            System.out.println("예외 안 터지고 실행됨" + data);
//        } catch (NoSuchElementException e) {
//            System.out.println("예외 터짐");
//        }
//
//        // 원하는 예외 터지도록 ->  Throw까지 된다
//        try {
//            String data = op.orElseThrow(() -> new RuntimeException("내가 생성한 예외"));
//        } catch(NoSuchElementException e) {
//
//        } catch(RuntimeException e) {
//            e.printStackTrace();
//            System.out.println("이쪽으로 예외 처리함");
//        }
//        op.orElseThrow();
//
//
//    }
}
