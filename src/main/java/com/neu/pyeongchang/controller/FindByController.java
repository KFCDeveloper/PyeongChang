package com.neu.pyeongchang.controller;

import com.neu.pyeongchang.ajaxresponsebody.AthleteAjaxResponseBody;
import com.neu.pyeongchang.ajaxresponsebody.CompetitionAjaxResponseBody;
import com.neu.pyeongchang.ajaxresponsebody.TeamAjaxResponseBody;
import com.neu.pyeongchang.model.Athlete;
import com.neu.pyeongchang.model.Competition;
import com.neu.pyeongchang.model.Team;
import com.neu.pyeongchang.repository.AthleteRepository;
import com.neu.pyeongchang.repository.CompetitionRepository;
import com.neu.pyeongchang.repository.TeamRepository;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FindByController {
    private static final Logger logger = LoggerFactory.getLogger(EditController.class);

    private final AthleteRepository athleteRepository;

    private final TeamRepository teamRepository;

    private final CompetitionRepository competitionRepository;
    @Autowired
    public FindByController(AthleteRepository athleteRepository, TeamRepository teamRepository, CompetitionRepository competitionRepository) {
        this.athleteRepository = athleteRepository;
        this.teamRepository = teamRepository;
        this.competitionRepository = competitionRepository;
    }

    @RequestMapping(value = "/page/AllAthleteDisplay", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAthleteListViaAjax() {
        AthleteAjaxResponseBody result = new AthleteAjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message


        List<Athlete> athletes = athleteRepository.findAll();
        if (athletes.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        System.out.println(athletes);
        result.setResult(athletes);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/page/AllCompetitionDisplay", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCompetitionListViaAjax() {
        CompetitionAjaxResponseBody result = new CompetitionAjaxResponseBody();
        //If error, just return a 400 bad request, along with the error message


        List<Competition> competitions = competitionRepository.findAll();
        if (competitions.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        System.out.println(competitions);
        result.setResult(competitions);
        return ResponseEntity.ok(result);
    }


    @RequestMapping(value = "/page/AllTeamDisplay", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getTeamListViaAjax() {
        TeamAjaxResponseBody result = new TeamAjaxResponseBody();
        //If error, just return a 400 bad request, along with the error message


        List<Team> teams = teamRepository.findAll();
        if (teams.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        System.out.println(teams);
        result.setResult(teams);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/page/DisplayAthleteByIdCollection", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?>getAthleteByIdCollection(@RequestBody String IdCollectionString){
        System.out.println(IdCollectionString);
        List<Integer> AidStringList = (List) JSONArray.toList(JSONArray.fromObject(IdCollectionString), "", new JsonConfig());

//        System.out.println(String.valueOf(AidStringList.get(0)));

        List<Athlete> athletes = athleteRepository.findAllById(AidStringList);
        return ResponseEntity.ok(athletes);
    }

    @RequestMapping(value = "/page/DisplayTeamByIdCollection", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?>getTeamByIdCollection(@RequestBody String IdCollectionString){
        System.out.println(IdCollectionString);
        List<Integer> TidStringList = (List) JSONArray.toList(JSONArray.fromObject(IdCollectionString), "", new JsonConfig());

//        System.out.println(String.valueOf(AidStringList.get(0)));

        List<Team> teams = teamRepository.findAllById(TidStringList);
        return ResponseEntity.ok(teams);
    }

    @RequestMapping(value = "/page/AthletesSearching", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?>getAthleteSearchCollection(@RequestParam(value = "Country")String country,@RequestParam(value = "Name")String name){
        System.out.println(country);
        System.out.println(name);
        List<Athlete> athletes = null;
        if (country.equals("All Countries")&&name.equals("null")){
            athletes = athleteRepository.findAll();
        }else if (country.equals("All Countries")&&!name.equals("null")){
            athletes = athleteRepository.findByName(name);
        }else if(!country.equals("All Countries")&&name.equals("null")){
            athletes = athleteRepository.findByCountry(country);
        }else if(!country.equals("All Countries")&&!name.equals("null")){
            athletes = athleteRepository.findByNameAndCountry(name,country);
        }
        return ResponseEntity.ok(athletes);
    }

    @RequestMapping(value = "/page/TeamsSearching", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?>getTeamSearchCollection(@RequestParam(value = "Country")String country,@RequestParam(value = "ID")String id){
        System.out.println(country);
        System.out.println(id);
        List<Team> teams = null;
        if (country.equals("All Countries")&&id.equals("null")){
            teams = teamRepository.findAll();
        }else if (country.equals("All Countries")&&!id.equals("null")){
            int tid = Integer.parseInt(id);
            teams = teamRepository.findByTid(tid);
        }else if(!country.equals("All Countries")&&id.equals("null")){
            teams = teamRepository.findByCountry(country);
        }else if(!country.equals("All Countries")&&!id.equals("null")){
            int tid = Integer.parseInt(id);
            teams = teamRepository.findByTidAndCountry(tid,country);
        }
        return ResponseEntity.ok(teams);
    }

    @RequestMapping(value = "/MedalRanking/PassCategory", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?>getSpecifiedCompetition(@RequestParam(value = "category") String category){
        List<Competition> competitions = null;
        if (category.equals("All Sports")){
            competitions = competitionRepository.findAll();
        }else if (!category.equals("All Sports")){
            competitions = competitionRepository.findAllByCategoryFirstlayer(category);
        }
        return ResponseEntity.ok(competitions);
    }
}
