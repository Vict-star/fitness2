package com.software.fitness.dao;

import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CoachDao {

    List<Coach> listCoach();

    Integer update(Coach coach);

    Integer insert(Coach coach);

    Coach getCoachById(int id);

}
