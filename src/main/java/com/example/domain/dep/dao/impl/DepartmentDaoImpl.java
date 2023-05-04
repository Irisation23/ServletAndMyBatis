package com.example.domain.dep.dao.impl;

import com.example.conf.SqlSessionManager;
import com.example.data.dep.DepartmentsMapper;
import com.example.domain.dep.dao.DepartmentDao;
import com.example.domain.dep.vo.Departments;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DepartmentDaoImpl implements DepartmentDao {

    private static final DepartmentDao departmentDao = new DepartmentDaoImpl();
    private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();

    public static DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    @Override
    public List<Departments> findByAllDepartment() {
        List<Departments> departmentsList;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepartmentsMapper departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);
            departmentsList = departmentsMapper.findAllDepartments();
        }

        return null;
    }
}
