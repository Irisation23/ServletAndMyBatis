package com.example.domain.dep.service.impl;

import com.example.domain.dep.dao.impl.DepartmentDaoImpl;
import com.example.domain.dep.service.DepartmentService;
import com.example.domain.dep.vo.Departments;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private static final DepartmentService departmentService = new DepartmentServiceImpl();

    public static DepartmentService getDepartmentService() {
        return departmentService;
    }

    @Override
    public List<Departments> selectAll() {
        return DepartmentDaoImpl.getDepartmentDao().findByAllDepartment();
    }
}
