package com.example.domain.member.dao.impl;

import com.example.conf.SqlSessionManager;
import com.example.data.member.MemberMapper;
import com.example.domain.member.dao.MemberDao;
import org.apache.ibatis.session.SqlSession;

public class MemberDaoImpl implements MemberDao {

    private static final MemberDao instance = new MemberDaoImpl();

    private MemberDaoImpl() {}

    public static MemberDao getInstance() {
        return instance;
    }

    @Override
    public String findByPassword(String id) {
        String pwd = null;

        try (SqlSession sqlSession = SqlSessionManager.getSqlSessionFactory().openSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            pwd = memberMapper.findByPassword(id);
        }

        return pwd;
    }
}
