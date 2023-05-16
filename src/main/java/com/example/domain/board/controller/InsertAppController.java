package com.example.domain.board.controller;

import com.example.domain.board.service.BoardService;
import com.example.domain.board.service.impl.BoardServiceImpl;
import com.example.domain.board.vo.CrudApp;
import com.example.globalcontroller.ForwardController;
import com.example.globalcontroller.ProcessController;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InsertAppController implements ProcessController {

    private String path;
    private boolean redirect;

    private final BoardService boardService = BoardServiceImpl.getBoardService();

    @Override
    public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
        // upload, insert
        int size = 10 * 1024 * 1024; // 10mb

        String uploadPath = request.getServletContext().getRealPath("/") + "static/upload";

        try {
            MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, size, "utf-8",
                new DefaultFileRenamePolicy());

            Enumeration<String> e = multipartRequest.getFileNames();
            String file = e.nextElement();

//            System.out.println("e.nextElement(): " + file);
//            System.out.println("multipartRequest.getParameter(file)" + multipartRequest.getOriginalFileName(file));

            CrudApp crudApp = CrudApp.builder()
                                     .writer(multipartRequest.getParameter("writer"))
                                     .password(multipartRequest.getParameter("pwd"))
                                     .contents(multipartRequest.getParameter("contents"))
                                     .id(multipartRequest.getParameter("id"))
                                     .title(multipartRequest.getParameter("title"))
                                     .fileName(multipartRequest.getOriginalFileName(file))
                                     .build();

            System.out.println("board password: " + crudApp.getPassword());
            boardService.insertBoard(crudApp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ForwardController(path, redirect);
    }
}
