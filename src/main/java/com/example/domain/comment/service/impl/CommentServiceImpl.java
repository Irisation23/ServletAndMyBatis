package com.example.domain.comment.service.impl;

import com.example.domain.comment.dao.impl.CommentDaoImpl;
import com.example.domain.comment.dto.CommentInsertDto;
import com.example.domain.comment.service.CommentService;
import com.example.domain.comment.vo.Comment;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private static final CommentService instance = new CommentServiceImpl();

    private CommentServiceImpl() {
    }

    public static CommentService getInstance() {
        return instance;
    }

    @Override
    public void insertComment(CommentInsertDto commentInsertDto) {
        CommentDaoImpl.getInstance().insertComment(commentInsertDto);
    }

    @Override
    public List<Comment> selectAll(int boardNo) {
        return CommentDaoImpl.getInstance().selectAll(boardNo);
    }
}
