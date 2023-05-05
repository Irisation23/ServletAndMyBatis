package com.example.domain.dep.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Departments {

    private final int departmentId;
    private final String departmentName;
    private final Integer managerId;
    private final Integer locationId;
}
