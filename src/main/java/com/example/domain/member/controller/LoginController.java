package com.example.domain.member.controller;

import com.example.domain.member.service.impl.MemberServiceImpl;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginController implements ProcessController {

    private String path;
    private boolean redirect;

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        String dbPwd = MemberServiceImpl.getInstance().findByPassword(id);

        if (dbPwd != null && dbPwd.equals(pwd)) {
            request.getSession().setAttribute("id", id);
            request.getSession().setMaxInactiveInterval(60);

            request.setAttribute("state", "T");
        } else {
            request.setAttribute("state", "F");
        }

        path = "member/ajax-login-state.jsp";

        return new ForwardController(path, redirect);
    }
}
