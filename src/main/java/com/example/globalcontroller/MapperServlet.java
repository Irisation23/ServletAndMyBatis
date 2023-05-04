package com.example.globalcontroller;

import com.example.domain.emp.controller.EmpController;

public class MapperServlet {

    private MapperServlet() {}

    public static ProcessController getMapper(String cmd) {
        ProcessController processController = null;

        if (cmd.equals("emp-list")) {
            processController = new EmpController("/emp/emp-list.jsp", false);
        }

        return processController;
    }
}
