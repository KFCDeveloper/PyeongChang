package com.neu.pyeongchang.repository;

import com.neu.pyeongchang.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into competition(category,date,result,state,team_orindividual) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    int addCompetitionToCompetition(String category,String date,String result,String state,String teamOrindividual);


    List<Competition> findAllByCategoryFirstlayer(String categoryFirstlayer);

}
