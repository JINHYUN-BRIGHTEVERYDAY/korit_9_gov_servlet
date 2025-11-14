package com.example.servlet_study.ch11_2.dao;

import com.example.servlet_study.ch11.util.DBConnectionMgr;
import com.example.servlet_study.ch11_2.entity.Professor;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO -> 데이터베이스 관련 기능
@RequiredArgsConstructor
public class ProfessorDao {
//    private final DBConnectionMgr dbConnectionMgr;
//    private final DataSource dataSource;
//    private final ProfessorDao professorDao;

    public List<Professor> findAllLikeName(String name) {
        DBConnectionMgr mgr = DBConnectionMgr.getInstance();
        List<Professor> professors = new ArrayList<>();

        // 커넥션 객체
        // 함수 안에 있는 변수는 초기화
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // DB에 연결
            con = mgr.getConnection();
            // SQL문 작성
            String sql = """
                    select
                        professor_id,
                        professor_name
                    from
                        professor_tb
                    where
                        professor_name like concat('%', ? , '%')
                    """;

            // PreparedStatement 는 con 객체 안에
//            PreparedStatement ps = con.prepareStatement(sql);

            // 결과받기
            // 물음표 안에 값 넣기 문자열
            // 매개변수로 받아온 name 넣기

            ps.setString(1, name);
//            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // List에 추가
//                professors.add(
//                        Professor.builder()
//                                .professorId(rs.getInt("professor_id"))
//                                .professorName(rs.getString("professor_name"))
//                                .build()
//                );

                // 변수로
                Professor professor = Professor.builder()
                        .professorId(rs.getInt("professor_id"))
                        .professorName(rs.getString("professor_name"))
                        .build();
                professors.add(professor);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // connection 해제
            if (rs != null)
            mgr.freeConnection(con, ps, rs);
        }

        return professors;
    }

}


    // findAll 사용하기
    // insert 빼버리고 findAll을 추가하여 조회할 수 있는 코드 작성해야 함
//    public List<Professor> findAll() {
//        List<Professor> professors = new ArrayList<>();
//
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            con = dbConnectionMgr.getConnection();
//            String sql = """
//                    select
//
//
//
//                    """
//        }
//    }

//    public void insert(Professor professor){

//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//
//        // try ~ catch
//        try {
//         con = dbConnectionMgr.getConnection();
//         String sql = """
//                 insert into professor_tb
//                 values (default, ?, ?)
//                 """;
//         ps.setInt(1, professor.getProfessorId());
//         ps.setString(2, professor.getProfessorName());
//         ps.execute();
//
//
//         if (ps.executeUpdate() < 1) {
//             throw new SQLException();
//         }
//
//         rs = ps.getGeneratedKeys();
//         while(rs.next()) {
//             int professorId = rs.getInt(1);
//             String professorName = rs.getString(2);
//         }
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//
//        } finally {
//            dbConnectionMgr.freeConnection(con, ps, rs);
//        }

//    }

    // findAll

