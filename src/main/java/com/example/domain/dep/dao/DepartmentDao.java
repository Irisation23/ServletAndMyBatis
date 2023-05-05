package com.example.domain.dep.dao;

import com.example.domain.dep.vo.Departments;
import java.util.List;

public interface DepartmentDao {

    List<Departments> findByAllDepartment();
}
