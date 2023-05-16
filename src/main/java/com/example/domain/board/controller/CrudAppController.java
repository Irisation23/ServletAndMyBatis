package com.example.domain.board.controller;

import com.example.domain.board.service.BoardService;
import com.example.domain.board.service.impl.BoardServiceImpl;
import com.example.domain.board.vo.CrudApp;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CrudAppController implements ProcessController {

    private String path;
    private boolean redirect;

    private final BoardService boardService = BoardServiceImpl.getBoardService();

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        List<CrudApp> boardList;
        Map<String, String> searchMap = new HashMap<>();
        ForwardController forwardController = new ForwardController(path, redirect);

        String option = request.getParameter("option");
        String keyword = request.getParameter("keyword");

        if (option == null && keyword == null) { // 검색어 데이터가 없을 경우
            boardList = boardService.selectAll(null);
        } else {

            searchMap.put("option", option);
            searchMap.put("keyword", keyword);
            boardList = boardService.selectAll(searchMap);
            System.out.println("boardList = " + boardList);
            redirect = false;
        }

        request.setAttribute("boardList", boardList);

        return forwardController;
    }
}
