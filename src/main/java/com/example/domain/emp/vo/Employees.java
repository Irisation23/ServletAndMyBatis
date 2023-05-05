package com.example.domain.emp.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Employees {

    private final int employeeId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String hireDate;
    private final Double salary;
    private final Double commissionPct;
    private final Integer managerId;
    private final Integer departmentId;
}
