package com.example.domain.sal.controller;

import com.example.domain.sal.service.impl.SalGradesServiceImpl;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalGradesController implements ProcessController {

    private final String path;
    private final boolean redirect;

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("salList", SalGradesServiceImpl.getSalService().selectAll());

        return new ForwardController(path, redirect);
    }
}
