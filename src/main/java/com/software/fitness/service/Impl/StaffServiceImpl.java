package com.software.fitness.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.fitness.dao.*;
import com.software.fitness.domain.*;
import com.software.fitness.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private CoachDao coachDao;

    @Override
    public boolean updateMember(Member member) {
        Integer row = memberDao.update(member);
        return row > 0;
    }

    @Override
    public boolean updateMemberall(Member member) {
        Integer row = memberDao.updateall(member);
        return row > 0;
    }


    @Override
    public Staff getStaffByID(String id) {
        return staffDao.getStaffByID(id);
    }

    @Override
    public List<Member> listMember() {
        return memberDao.listMember();
    }

    @Override
    public boolean addMember(Member member) {
        Integer row = memberDao.insert(member);
        return row > 0;
    }

    @Override
    public Member getMemberByID(int id) {
        return memberDao.getMemberById(id);
    }

    @Override
    public boolean updateCoach(Coach coach) {
        Integer row = coachDao.update(coach);
        return row > 0;
    }

    @Override
    public List<Coach> listCoach() { return coachDao.listCoach(); }

    @Override
    public boolean addCoach(Coach coach) {
        Integer row = coachDao.insert(coach);
        return row > 0;
    }

    @Override
    public Coach getCoachByID(int id) {
        return coachDao.getCoachById(id);
    }
}