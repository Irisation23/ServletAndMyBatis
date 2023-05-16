package com.example.domain.comment.controller;

import com.example.domain.comment.dto.CommentInsertDto;
import com.example.domain.comment.service.impl.CommentServiceImpl;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentInsertController implements ProcessController {

    private String path;
    private boolean redirect;

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        Integer boardNo = Integer.valueOf(request.getParameter("boardNo"));
        String comments = request.getParameter("contents");
        String writer = request.getParameter("writer");
        String password = request.getParameter("password");

        Integer parentCommentNo = null;

        String parentCommentNoString = request.getParameter("parentCommentNo");

        if (parentCommentNoString != null) {
             parentCommentNo = Integer.parseInt(parentCommentNoString);
        }


        CommentServiceImpl.getInstance().insertComment(CommentInsertDto.builder()
                                                                       .boardNo(boardNo)
                                                                       .contents(comments)
                                                                       .writer(writer)
                                                                       .password(password)
                                                                       .parentCommentNo(parentCommentNo)
                                                                       .build());
        path = "board-details.do?cmd=board-details&boardNo=" + boardNo;

        return new ForwardController(path, redirect);
    }
}
