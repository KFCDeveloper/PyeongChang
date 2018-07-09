package com.neu.pyeongchang.controller;

import com.neu.pyeongchang.model.Athlete;
import com.neu.pyeongchang.model.Team;
import com.neu.pyeongchang.repository.AthleteRepository;
import com.neu.pyeongchang.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(EditController.class);

    private final AthleteRepository athleteRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public HelloController(AthleteRepository athleteRepository, TeamRepository teamRepository) {
        this.athleteRepository = athleteRepository;
        this.teamRepository = teamRepository;
    }

    @RequestMapping("/hello")
    private void index(String name) {
        Athlete athlete = new Athlete(null, null, name, "../../1.jpg", "male", "CHN", "I'm best", "Gold");
        athleteRepository.addAthleteToAthlete(athlete.getBestResult(), athlete.getCountry(), athlete.getDescription(), athlete.getGender(), athlete.getName(), athlete.getPicture());
    }

    @RequestMapping("/InsertTeam")
    private void insertTeam(String name1,String name2){
        List<Athlete> athletes = athleteRepository.findAll();
        Set<Athlete>insertA = new HashSet<Athlete>();
        for (int i = 0;i<athletes.size();i++){
            if (athletes.get(i).getName().equals(name1)||athletes.get(i).getName().equals(name2)){
                insertA.add(athletes.get(i));
                i++;
            }
        }
//        Team team = new Team("HD",insertA,"Gold","me me ");
        Iterator<Athlete>athleteIterator = insertA.iterator();
        while(athleteIterator.hasNext()){
            System.out.println(athleteIterator.next().getName());
        }

        //List<Team>allTeams = teamRepository.findAll(new Sort(Sort.Direction.DESC, "Tid"));  //降序排列 ASC升序
//        teamRepository.saveAndFlush(team);
    }

    @RequestMapping("/findAllTeam")
    private void findAllTeam(){
        List<Team>allTeams = teamRepository.findAll();

        /*Set<Team> teams= new HashSet<Team>();
        Iterator<Team>teamIterator = teams.iterator();
        Team temporary = new Team();
        while(teamIterator.hasNext()){
            temporary = teamIterator.next();
            System.out.println( "Tid : "+ temporary.getTid()+
                                "Category : "+temporary.getCategory());
            for (int i = 0;i<temporary.getAthleteSet().size();i++){

            }

        }*/
    }

}
