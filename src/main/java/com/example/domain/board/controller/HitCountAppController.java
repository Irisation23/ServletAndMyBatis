package com.example.domain.board.controller;

import com.example.domain.board.service.impl.BoardServiceImpl;
import com.example.domain.board.vo.CrudApp;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HitCountAppController implements ProcessController {

    private String path;
    private boolean redirect;

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        CrudApp findCrudApp = BoardServiceImpl.getBoardService()
                                              .selectCrudApp(Integer.parseInt(request.getParameter("boardNo")));

        BoardServiceImpl.getBoardService().hitPlusCrudApp(findCrudApp);
        path = "/board-details.do?cmd=board-details&boardNo=" + findCrudApp.getNo();

        return new ForwardController(path, redirect);
    }
}
