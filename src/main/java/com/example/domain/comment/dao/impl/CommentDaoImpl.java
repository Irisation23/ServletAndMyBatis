package com.example.domain.comment.dao.impl;

import static com.example.conf.SqlSessionManager.sqlSessionFactory;

import com.example.data.comment.CommentMapper;
import com.example.domain.comment.dao.CommentDao;
import com.example.domain.comment.dto.CommentInsertDto;
import com.example.domain.comment.vo.Comment;
import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class CommentDaoImpl implements CommentDao {
    private static final CommentDao instance = new CommentDaoImpl();
    private CommentDaoImpl() {}
    public static CommentDao getInstance() {
        return instance;
    }

    @Override
    public void insertComment(CommentInsertDto commentInsertDto) {
        Comment comment = new Comment();
        comment.transferToBoardVo(commentInsertDto);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
            commentMapper.insertComment(comment);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> selectAll(int boardNo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
            return commentMapper.selectAll(boardNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
