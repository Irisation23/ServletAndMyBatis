package com.example.data.board;

import com.example.domain.board.vo.CrudApp;
import java.util.List;
import java.util.Map;

public interface BoardMapper {
    void insertBoard(CrudApp crudApp);
    List<CrudApp> selectBoardList();

    CrudApp selectCrudApp(int no);

    void hitPlusCrudApp(CrudApp findCrudApp);

    List<CrudApp> searchBoardList(Map<String, String> searchMap);
}
