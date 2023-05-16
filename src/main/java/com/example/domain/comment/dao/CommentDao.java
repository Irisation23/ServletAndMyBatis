package com.example.domain.comment.dao;

import com.example.domain.comment.dto.CommentInsertDto;
import com.example.domain.comment.vo.Comment;
import java.util.List;

public interface CommentDao {

    void insertComment(CommentInsertDto commentInsertDto);

    List<Comment> selectAll(int boardNo);
}
