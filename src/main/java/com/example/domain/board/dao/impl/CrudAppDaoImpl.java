package com.example.domain.board.dao.impl;

import static com.example.conf.SqlSessionManager.sqlSessionFactory;

import com.example.data.board.BoardMapper;
import com.example.domain.board.dao.CrudAppDao;
import com.example.domain.board.vo.CrudApp;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

public class CrudAppDaoImpl implements CrudAppDao {

    private static final CrudAppDao instance = new CrudAppDaoImpl();

    private CrudAppDaoImpl() {
    }

    public static CrudAppDao getInstance() {
        return instance;
    }

    @Override
    public List<CrudApp> selectAll(Map<String, String> searchMap) {
        List<CrudApp> boardList = null;

        if (searchMap != null) {
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
                boardList = boardMapper.searchBoardList(searchMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
                boardList = boardMapper.selectBoardList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return boardList;
    }
}
