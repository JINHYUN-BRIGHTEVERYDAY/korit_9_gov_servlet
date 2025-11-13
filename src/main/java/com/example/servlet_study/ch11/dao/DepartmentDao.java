package com.example.servlet_study.ch11.dao;

import com.example.servlet_study.ch11.entity.Department;
import com.example.servlet_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DepartmentDao {
    private final DBConnectionMgr mgr;

    public List<Department> findAll() { // connection은 try-catch
        List<Department> departments = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql = """
                    select
                        department_id,
                        department_code,
                        department_name
                    from
                        department_tb
                    order by
                        department_id
                    
                    """;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {

                Department department = Department.builder()
                        .departmentId(rs.getInt("department_id"))
                        .departmentCode(rs.getString("department_code"))
                        .departmentName(rs.getString("department_name"))
                        .build();

                departments.add(department);
            }

        } catch (Exception e) {
            e.printStackTrace(); // 프로그램 꺼지지 않게 예외만 출력하겠다
        } finally {
            mgr.freeConnection(con, ps, rs);
        }

        return departments;
    }
}
