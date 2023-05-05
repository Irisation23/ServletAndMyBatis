package com.example.domain.sal.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class SalGrades {

    private final Integer grade;
    private final Integer losal;
    private final Integer hisal;
}
