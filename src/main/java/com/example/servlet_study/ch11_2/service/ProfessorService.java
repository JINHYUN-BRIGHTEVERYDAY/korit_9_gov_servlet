package com.example.servlet_study.ch11_2.Service;

import com.example.servlet_study.ch11_2.dao.ProfessorDao;
import com.example.servlet_study.ch11_2.entity.Professor;

import java.util.List;

public class ProfessorService {
    /* servlet과 DAO 연결
    * */

    //List로 처리
    public List<Professor> getProfessors(String query) {
        ProfessorDao professorDao = new ProfessorDao();
        return professorDao.findAllLikeName(query);
    }

}

