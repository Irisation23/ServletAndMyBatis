package com.example.domain.member.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Member {

    private final int no;
    private final String id;
    private final String password;
    private final String name;
}
