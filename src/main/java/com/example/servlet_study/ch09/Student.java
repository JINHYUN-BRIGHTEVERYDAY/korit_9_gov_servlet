package com.example.servlet_study.ch09;


import lombok.*;


//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
@ToString
@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private String school;
}

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age='" + age + '\'' +
//                ", address='" + address + '\'' +
//                ", school='" + school + '\'' +
//                '}';
//    }


