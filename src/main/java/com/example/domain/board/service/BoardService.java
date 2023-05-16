package com.example.domain.board.service;

import com.example.domain.board.vo.CrudApp;
import java.util.List;
import java.util.Map;

public interface BoardService {

    void insertBoard(CrudApp crudApp);

    List<CrudApp> selectAll(Map<String, String> searchMap);
    CrudApp selectCrudApp(int no);

    void hitPlusCrudApp(CrudApp findCrudApp);
}
