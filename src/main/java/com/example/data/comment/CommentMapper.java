package com.example.data.comment;

import com.example.domain.comment.vo.Comment;
import java.util.List;

public interface CommentMapper {
    void insertComment(Comment comment);

    List<Comment> selectAll(int boardNo);
}
