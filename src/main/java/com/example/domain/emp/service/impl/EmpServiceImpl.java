package com.example.domain.emp.service.impl;

import com.example.domain.emp.dao.impl.EmployeesDaoImpl;
import com.example.domain.emp.service.EmpService;
import com.example.domain.emp.vo.Employees;
import java.util.List;

public class EmpServiceImpl implements EmpService {

    private static final EmpService empService = new EmpServiceImpl();

    @Override
    public List<Employees> selectAll() {
        return EmployeesDaoImpl.getEmployeesDao().findAllEmployees();
    }

    public static EmpService getEmpService() {
        return empService;
    }
}
