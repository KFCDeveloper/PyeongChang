package com.neu.pyeongchang.repository;

import com.neu.pyeongchang.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into team(category,bestresult,information) values(?1,?2,?3)",nativeQuery = true)
    int addTeamToTeam(String Category,String bestresult,String information);


    List<Team> findByTidAndCountry(int tid, String country);
    List<Team> findByTid(int tid);
    List<Team> findByCountry(String country);
}
