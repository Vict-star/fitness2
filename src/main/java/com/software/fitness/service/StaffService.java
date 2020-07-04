package com.software.fitness.service;

import com.software.fitness.domain.Member;
import com.software.fitness.domain.Staff;

import java.util.List;

/**
 * StaffService
 * 包括所有表的操作接口
 */

public interface StaffService {
    boolean updateMember(Member member);

    Staff getStaffByID(String id);

    List<Member> listMember();

    boolean addMember(Member member);

    Member getMemberByID(int id);
}
