package com.software.fitness.dao;

import com.software.fitness.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberDaoTest {
    @Autowired
    MemberDao memberDao;

    @Test
    void update() {
        Member member = new Member();
        member.setId(1);
        member.setState("已注销");
        memberDao.update(member);
    }
}