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

}
