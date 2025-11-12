package com.example.servlet_study.ch10;

import java.sql.*;

/*

JDBC : Java DataBase Connection

*/
public class JDBCMain {
    public static void main(String[] args) {
        // http://ip:port -> http 프로토콜
        // jdbc:mysql://ip:port -> jdbc:mysql 프로토콜
        // mysql의 port : 기본 (3306), 우리가 설정 (3309)

        // 프로토콜://IP주소:PORT번호/데이터베이스(스키마)이름

        // 스키마 이름 맞춰서
        final String URL = "jdbc:mysql://localhost:3309/student_tb";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        // Connection 객체 생성, 자바 SQL의 커넥션
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = """
                   select * from student_tb where student_name = '김준일'
                   """;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); // Result 결과 나오는 건 Select
            rs.next();  // while(rs.hasNext());
            int studentId = rs.getInt("student_id");
            String studentName = rs.getString("student_name");
            System.out.println("id: " + studentId);
            System.out.println("name: " + studentName);

        } catch (SQLException e) {
            e.printStackTrace(); // 예외 메시지 출력하기
            System.out.println("데이터 베이스 연결 실패했어요");
        }

    }
}
