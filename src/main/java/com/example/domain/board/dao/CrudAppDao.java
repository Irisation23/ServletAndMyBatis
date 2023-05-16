package com.example.domain.board.dao;

import com.example.domain.board.vo.CrudApp;
import java.util.List;
import java.util.Map;

public interface CrudAppDao {

    List<CrudApp> selectAll(Map<String, String> searchMap);
}
