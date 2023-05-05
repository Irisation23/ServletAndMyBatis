package com.example.domain.dep.service;

import com.example.domain.dep.vo.Departments;
import java.util.List;

public interface DepartmentService {

    List<Departments> selectAll();
}
