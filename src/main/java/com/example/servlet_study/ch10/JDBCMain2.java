package com.example.servlet_study.ch10;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class JDBCMain2 {
    public static void main(String[] args) {
        // 고정적 주소
        final String URL = "jdbc:mysql://localhost:3309/student_tb";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        //            Class.forName("com.mysql.cj.jdbc.Driver");

        /*
         * print
         *
         * 과목ID : 46
         * 과목CODE : CS203
         * 과목명 : 프로그래밍 언어론
         * 교수명 : 교수명이 누군지?
         * 학점 : 3
         * 수용인원 : 42
         * 강의장 : ------
         *
         * */

        String searchData = "프로그래밍언어론";

        try {
            // 1. DB Connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. SQL 작성
            String sql = """
                   /* select 범위 지정되어있었어야 했음*/
                   
                   select 
                       ct.course_id,
                       ct.course_code,
                       ct.course_name,
                       pt.professor_id,
                       pt.professor_name,
                       ct.credit,
                       ct.enrollment_capacity,
                       ct.classroom
                   
                   from 
                       course_tb ct 
                       join professor_tb pt on ct.professor_id = pt.professor_id
                   
                    where
                        ct.course_name like concat('%', ? , '%')
                        
                   """;


            // 3. SQL문 실행을 위한 PreparedStatement 생성하기
            PreparedStatement ps = connection.prepareStatement(sql);


            // 4. ? 와일드카드 위치에 값 매핑하기(1 = 몇 번째 물음표인지)
            ps.setString(1, searchData);


            // 5. 결과를 ResultSet 객체로 가져오기
            ResultSet rs = ps.executeQuery();


            while(rs.next()) { // next가 true이면 다음 rs 호출
                /*

                Map<String, Object> resultMap = Map.of(

                        "course_id", rs.getInt("course_id"),
                        "course_code", rs.getString("course_code"),
                        "course_name", rs.getString("course_name"),
                        "professor_name", rs.getString("professor_name"),
                        "credit", rs.getInt("credit"),
                        "enrollment_capacity", rs.getInt("enrollment_capacity"),
                        "classroom", rs.getString("classroom")

                );*/

                // Map이라도 순서를 보장하려면
                Map<String, Object> resultMap = new LinkedHashMap<>(); // 순서보장
                resultMap.put("course_id", rs.getInt("course_id"));
                resultMap.put("course_code", rs.getString("course_code"));
                resultMap.put("course_name", rs.getString("course_name"));
                resultMap.put("professor_name", rs.getString("professor_name"));
                resultMap.put("credit", rs.getInt("credit"));
                resultMap.put("enrollment_capacity", rs.getInt("enrollment_capacity"));
                resultMap.put("classroom", rs.getString("classroom"));
                System.out.println(resultMap);

                @Data
                @AllArgsConstructor
                class Professor {
                    private int professorId;
                    private String professorname;
                }


                @Data
                @AllArgsConstructor
                class Course {
                    private int courseId;
                    private String courseCode;
                    private String courseName;
                    private Professor professor;
                    private int credit;
                    private int enrollmentCapacity;
                    private String classroom;
                }

                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_code"),
                        rs.getString("course_name"),
                        new Professor(rs.getInt("professor_id"), rs.getString("professor_name")),
                        rs.getInt("credit"),
                        rs.getInt("enrollment_capacity"),
                        rs.getString("classroom")
                );
                System.out.println(course);
            }


        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}


// 1차적으로 조인 적용

/*
 * print
 *
 * 과목ID : 46
 * 과목CODE : CS203
 * 과목명 : 프로그래밍 언어론
 * 교수명 : 교수명이 누군지?
 * 학점 : 3
 * 수용인원 : 42
 * 강의장 : ------
 *
 * 서브쿼리로 할 수 있는 방법은?
 *
 * 교수명을 합쳐야 하는 상황임
 * 교수번호를 합칠 수 있는데 결국 합쳐서 불러와야 하는 건 교수의 이름
 *
 * select * from course_tb
 *          where couse_id = 46;
 *              and
 *
 * */