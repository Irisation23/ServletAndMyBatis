package com.example.data.emp;

import com.example.domain.emp.vo.Employees;
import java.util.List;


public interface EmployeesMapper {
    List<Employees> findAllEmployees();
}
