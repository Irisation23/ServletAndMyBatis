package com.example.domain.board.controller;

import com.example.domain.board.service.impl.BoardServiceImpl;
import com.example.domain.board.vo.CrudApp;
import com.example.domain.comment.service.impl.CommentServiceImpl;
import com.example.domain.comment.vo.Comment;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DetailsAppController implements ProcessController {

    private String path;
    private boolean redirect;

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        CrudApp findCrudApp = BoardServiceImpl.getBoardService()
                                              .selectCrudApp(Integer.parseInt(request.getParameter("boardNo")));

        List<Comment> comments = CommentServiceImpl.getInstance()
                                                   .selectAll(Integer.parseInt(request.getParameter("boardNo")));

        request.setAttribute("findCrudApp", findCrudApp);
        request.setAttribute("comments", comments);

        return new ForwardController(path, redirect);
    }
}
