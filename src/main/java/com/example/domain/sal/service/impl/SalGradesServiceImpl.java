package com.example.domain.sal.service.impl;

import com.example.domain.sal.dao.impl.SalGradesDaoImpl;
import com.example.domain.sal.service.SalGradesService;
import com.example.domain.sal.vo.SalGrades;
import java.util.List;

public class SalGradesServiceImpl implements SalGradesService {

    private static final SalGradesService salGradesService = new SalGradesServiceImpl();

    public static SalGradesService getSalService() {
        return salGradesService;
    }

    @Override
    public List<SalGrades> selectAll() {
        return SalGradesDaoImpl.getSalGradesDao().findAllSalGrades();
    }
}
