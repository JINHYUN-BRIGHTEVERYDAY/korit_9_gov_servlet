package com.example.servlet_study.ch11_1.dao;

import com.example.servlet_study.ch11.util.DBConnectionMgr;
import com.example.servlet_study.ch11_1.entity.Course;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@RequiredArgsConstructor
public class CourseDao {
    private final DBConnectionMgr mgr;

    public void insert(Course course) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql = """
                    insert into course_tb
                    values (default, ?, ?, ?, ?, ?, ?, ?)
                    """;
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseCode());
            ps.setString(3, course.getCourseName());
            ps.setInt(4, course.getProfessorId());
            ps.setInt(5, course.getCredit());
            ps.setInt(6, course.getEnrollmentCapacity());
            ps.setString(7, course.getClassroom());
            ps.execute();

            if (!ps.execute()) {
                throw new SQLException();
            }

            rs =  ps.getGeneratedKeys();
            while(rs.next()) {
                int courseId = rs.getInt(1);
                course.setCourseId(courseId);
            }

            // 예외처리를 어떻게 할 것인지
        } catch (Exception e) {
            throw new RuntimeException(e);
            // 그리하여 반환되는 값을 무엇으로 나타낼 것인지
        } finally {
            mgr.freeConnection(con, ps, rs);
        }
    }
}
