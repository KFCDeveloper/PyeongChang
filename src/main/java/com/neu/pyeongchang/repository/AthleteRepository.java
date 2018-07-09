package com.neu.pyeongchang.repository;


import com.neu.pyeongchang.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into athlete(best_result,country,description,gender,name,picture) values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    int addAthleteToAthlete(String bestResult,String country,String description,String gender,String name,String picture);

    /*//查询用户名称包含username字符串的用户对象
    List<Athlete> findByNameContaining(String name);

    //精确匹配username的用户对象
    Athlete getByNameIs(String name);*/

    List<Athlete> findByNameAndCountry(String name, String country);
    List<Athlete> findByName(String name);
    List<Athlete> findByCountry(String country);
}
