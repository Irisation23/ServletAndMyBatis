package com.example.domain.sal.dao.impl;

import com.example.conf.SqlSessionManager;
import com.example.data.sal.SalGradesMapper;
import com.example.domain.sal.dao.SalGradesDao;
import com.example.domain.sal.vo.SalGrades;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SalGradesDaoImpl implements SalGradesDao {

    private static final SalGradesDao salGradesDao = new SalGradesDaoImpl();
    private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();

    public static SalGradesDao getSalGradesDao() {
        return salGradesDao;
    }

    @Override
    public List<SalGrades> findAllSalGrades() {
        List<SalGrades> salGradesList;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SalGradesMapper salGradesMapper = sqlSession.getMapper(SalGradesMapper.class);
            salGradesList = salGradesMapper.findAllSalGrades();
        }

        return salGradesList;
    }
}
