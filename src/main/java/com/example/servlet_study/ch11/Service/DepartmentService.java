package com.example.servlet_study.ch11.Service;

import com.example.servlet_study.ch11.dao.DepartmentDao;
import com.example.servlet_study.ch11.entity.Department;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentDao departmentDao;


    public List<Department> getDepartments() {
        return departmentDao.findAll();
    }


}
