package com.example.servlet_study.ch11_2.dao;

import com.example.servlet_study.ch11.util.DBConnectionMgr;
import com.example.servlet_study.ch11_2.entity.Professor;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class ProfessorDao {
    private final DBConnectionMgr dbConnectionMgr;
    private final DataSource dataSource;
    private final ProfessorDao professorDao;

    public void insert(Professor professor){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
         con = dbConnectionMgr.getConnection();
         String sql = """
                 insert into professor_tb
                 values (default, ?, ?)
                 """;
         ps.setInt(1, professor.getProfessorId());
         ps.setString(2, professor.getProfessorName());
         ps.execute();

         if (!ps.execute()) {
             throw new SQLException();
         }

         rs = ps.getGeneratedKeys();
         while(rs.next()) {
             int professorId = rs.getInt(1);
             String professorName = rs.getString(2);
         }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            dbConnectionMgr.freeConnection(con, ps, rs);
        }

    }

}
