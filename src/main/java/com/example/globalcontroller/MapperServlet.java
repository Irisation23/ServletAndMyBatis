package com.example.globalcontroller;

import com.example.domain.dep.controller.DepartmentController;
import com.example.domain.emp.controller.EmpController;
import com.example.domain.sal.controller.SalGradesController;

public class MapperServlet {

    private MapperServlet() {
    }

    public static ProcessController getMapper(String cmd) {
        ProcessController processController = null;

        if (cmd.equals("emp-list")) {
            processController = new EmpController("/emp/emp-list.jsp", false);
        }

        if (cmd.equals("dep-list")) {
            processController = new DepartmentController("/dep/dep-list.jsp", false);
        }

        if (cmd.equals("sal-list")) {
            processController = new SalGradesController("/sal/sal-list.jsp", false);
        }

        return processController;
    }
}
