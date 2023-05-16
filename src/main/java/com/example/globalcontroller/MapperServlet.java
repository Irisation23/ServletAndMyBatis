package com.example.globalcontroller;

import com.example.domain.board.controller.CrudAppController;
import com.example.domain.board.controller.DetailsAppController;
import com.example.domain.board.controller.HitCountAppController;
import com.example.domain.board.controller.InsertAppController;
import com.example.domain.comment.controller.CommentInsertController;
import com.example.domain.dep.controller.DepartmentController;
import com.example.domain.emp.controller.EmpController;
import com.example.domain.member.controller.LoginController;
import com.example.domain.sal.controller.SalGradesController;

public class MapperServlet {

    private MapperServlet() {
    }

    public static ProcessController getMapper(String cmd) {
        ProcessController processController = null;

        if (cmd.equals("emp-list")) {
            processController = new EmpController("/emp/emp-list.jsp", false);
        }

        if (cmd.equals("dep-list")) {
            processController = new DepartmentController("/dep/dep-list.jsp", false);
        }

        if (cmd.equals("sal-list")) {
            processController = new SalGradesController("/sal/sal-list.jsp", false);
        }

        if (cmd.equals("login")) {
            processController = new LoginController("", false);
        }

        if (cmd.equals("board-list")) {
            System.out.println("보드 리스트 입장!");
            processController = new CrudAppController("/board/board-list.jsp", false);
        }

        if (cmd.equals("board-insert")) {
            System.out.println("보드 생성 입장!");
            processController = new InsertAppController("/board-list.do?cmd=board-list", true);
        }

        if (cmd.equals("board-hit")) {
            System.out.println("보드 Hit 입장!");
            processController = new HitCountAppController("", true);

        }

        if (cmd.equals("board-details")) {
            System.out.println("보드 수정 입장!");
            processController = new DetailsAppController("/board/board-details.jsp", false);
        }

        if (cmd.equals("comment-insert")) {
            System.out.println("댓글 생성 입장!");
            processController = new CommentInsertController("", true);
        }

        return processController;
    }
}
