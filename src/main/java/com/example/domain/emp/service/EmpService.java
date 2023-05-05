package com.example.domain.emp.service;

import com.example.domain.emp.vo.Employees;
import java.util.List;

public interface EmpService {

    List<Employees> selectAll();
}
