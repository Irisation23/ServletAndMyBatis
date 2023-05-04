package com.example.globalcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProcessController {

    ForwardController execute(HttpServletRequest request, HttpServletResponse response);
}
