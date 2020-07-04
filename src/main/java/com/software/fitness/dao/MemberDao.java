package com.software.fitness.dao;

import com.software.fitness.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberDao {

    List<Member> listMember();

    Integer update(Member member);

    Integer insert(Member member);

    Member getMemberById(int id);
}
