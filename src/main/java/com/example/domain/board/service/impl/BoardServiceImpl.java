package com.example.domain.board.service.impl;

import static com.example.conf.SqlSessionManager.sqlSessionFactory;

import com.example.data.board.BoardMapper;
import com.example.domain.board.dao.impl.CrudAppDaoImpl;
import com.example.domain.board.service.BoardService;
import com.example.domain.board.vo.CrudApp;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

public class BoardServiceImpl implements BoardService {

    private static final BoardService instance = new BoardServiceImpl();

    private BoardServiceImpl() {
    }
    public static BoardService getBoardService() {
        return instance;
    }

    @Override
    public void insertBoard(CrudApp crudApp) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            System.out.println(crudApp);
            boardMapper.insertBoard(crudApp);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CrudApp> selectAll(Map<String, String> searchMap) {
        return CrudAppDaoImpl.getInstance().selectAll(searchMap);
    }

    @Override
    public CrudApp selectCrudApp(int no) {
        CrudApp crudApp = null;

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            crudApp = boardMapper.selectCrudApp(no);
        }catch (Exception e){
            e.printStackTrace();
        }

        return crudApp;
    }

    @Override
    public void hitPlusCrudApp(CrudApp findCrudApp) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            boardMapper.hitPlusCrudApp(findCrudApp);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
