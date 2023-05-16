package com.example.domain.member.service.impl;

import com.example.domain.member.dao.impl.MemberDaoImpl;
import com.example.domain.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
    private static final MemberService instance = new MemberServiceImpl();
    private MemberServiceImpl() {}

    public static MemberService getInstance() {
        return instance;
    }

    @Override
    public String findByPassword(String id) {
        return MemberDaoImpl.getInstance().findByPassword(id);
    }
}
