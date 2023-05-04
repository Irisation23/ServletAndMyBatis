package com.example.data.dep;

import com.example.domain.dep.vo.Departments;
import java.util.List;

public interface DepartmentsMapper {

    List<Departments> findAllDepartments();
}
