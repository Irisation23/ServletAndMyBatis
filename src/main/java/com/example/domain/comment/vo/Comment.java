package com.example.domain.comment.vo;

import com.example.domain.comment.dto.CommentInsertDto;
import lombok.Getter;
@Getter
public class Comment {

    private int commentNo;
    private Integer boardNo;
    private String writer;
    private String password;
    private String contents;
    private String regDate;
    private Integer parentCommentNo;

    public void transferToBoardVo(CommentInsertDto commentInsertDto) {
        this.boardNo = commentInsertDto.getBoardNo();
        this.contents = commentInsertDto.getContents();
        this.writer = commentInsertDto.getWriter();
        this.password = commentInsertDto.getPassword();
        this.parentCommentNo = commentInsertDto.getParentCommentNo();
    }
}
