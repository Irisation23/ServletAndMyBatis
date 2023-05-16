package com.example.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class CommentInsertDto {

    private final Integer boardNo;
    private final String contents;
    private final String writer;
    private final String password;
    private final Integer parentCommentNo;
}
