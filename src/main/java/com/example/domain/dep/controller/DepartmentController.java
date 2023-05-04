package com.example.domain.dep.controller;

import com.example.domain.dep.dao.impl.DepartmentDaoImpl;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartmentController implements ProcessController {

    private final String path;
    private final boolean redirect;
    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("depList", DepartmentDaoImpl.getDepartmentDao().findByAllDepartment());

        return null;
    }
}
