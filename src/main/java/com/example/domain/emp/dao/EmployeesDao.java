package com.example.domain.emp.dao;

import com.example.domain.emp.vo.Employees;
import java.util.List;

public interface EmployeesDao {

    List<Employees> findAllEmployees();
}
