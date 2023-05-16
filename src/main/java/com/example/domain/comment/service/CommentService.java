package com.example.domain.comment.service;

import com.example.domain.comment.dto.CommentInsertDto;
import com.example.domain.comment.vo.Comment;
import java.util.List;

public interface CommentService {

    void insertComment(CommentInsertDto commentInsertDto);

    List<Comment> selectAll(int boardNo);
}
