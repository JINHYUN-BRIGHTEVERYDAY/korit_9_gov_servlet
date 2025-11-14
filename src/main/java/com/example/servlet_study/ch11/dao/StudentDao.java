package com.example.servlet_study.ch11.dao;

import com.example.servlet_study.ch11.entity.Student;
import com.example.servlet_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.*;


@RequiredArgsConstructor
public class StudentDao {
    private final DBConnectionMgr mgr;
    //Required 때문에 final, final이 없으면 AllArgs

    public void insert(Student student) {
        // null로 초기화
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            con = mgr.getConnection();
            String sql = """
                    insert into student_tb
                    values (default, ?, ?, ?, ?, ?, ?, ?)
                    """;
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getPhone());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getDepartmentId());
            ps.setInt(5, student.getGrade());
            ps.setString(6, student.getAdmissionYear());
            ps.setString(7, student.getMajorType());
            ps.execute(); // 쿼리 실행하세요


            if (ps.executeUpdate() < 1) {
                throw new SQLException();
            }

            // 생성된 키들
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int studentId = rs.getInt(1);
                student.setStudentId(studentId);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // null로 초기화한 이유
           mgr.freeConnection(con, ps, rs);
        }
    }
}
