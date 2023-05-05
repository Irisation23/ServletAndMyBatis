package com.example.domain.emp.dao.impl;

import com.example.conf.SqlSessionManager;
import com.example.data.emp.EmployeesMapper;
import com.example.domain.emp.dao.EmployeesDao;
import com.example.domain.emp.vo.Employees;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmployeesDaoImpl implements EmployeesDao {

    private static final EmployeesDao employeesDao = new EmployeesDaoImpl();
    private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();

    public static EmployeesDao getEmployeesDao() {
        return employeesDao;
    }

    @Override
    public List<Employees> findAllEmployees() {
        List<Employees> employeesList;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeesMapper employeesMapper = sqlSession.getMapper(EmployeesMapper.class);
            employeesList = employeesMapper.findAllEmployees();
        }

        return employeesList;
    }
}
