package com.neu.pyeongchang.controller;


import com.neu.pyeongchang.NoModelJavaBean.ResultOfAthletes;
import com.neu.pyeongchang.NoModelJavaBean.ResultOfTeam;
import com.neu.pyeongchang.ajaxresponsebody.AddCompetitionAjaxRequestBody;
import com.neu.pyeongchang.ajaxresponsebody.SaveCompetitionAjaxRequestBody;
import com.neu.pyeongchang.model.Athlete;
import com.neu.pyeongchang.model.Competition;
import com.neu.pyeongchang.model.Team;
import com.neu.pyeongchang.repository.AthleteRepository;
import com.neu.pyeongchang.repository.CompetitionRepository;
import com.neu.pyeongchang.repository.TeamRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class EditController {
    private static final Logger logger = LoggerFactory.getLogger(EditController.class);

    private final AthleteRepository athleteRepository;

    private final TeamRepository teamRepository;

    private final CompetitionRepository competitionRepository;

    @Autowired
    public EditController(AthleteRepository athleteRepository, TeamRepository teamRepository, CompetitionRepository competitionRepository) {
        this.athleteRepository = athleteRepository;
        this.teamRepository = teamRepository;
        this.competitionRepository = competitionRepository;
    }

    @RequestMapping(value = "/admin/AddCompetitionAthleteTpye", method = RequestMethod.POST)
    @ResponseBody
    public void AddIndividualCompetition(@RequestBody AddCompetitionAjaxRequestBody ajaxRequestBody) {
        System.out.println(ajaxRequestBody.toString());
        //get athlete id list
        List<String> AidStringList = (List) JSONArray.toList(JSONArray.fromObject(ajaxRequestBody.getIdcollection()), "", new JsonConfig());
        List<Integer>AidList = new ArrayList<Integer>();
        for (int i = 0;i<AidStringList.size();i++){                         //get aidList. generic is Integer
            AidList.add(Integer.parseInt(AidStringList.get(i)));
        }

        List<Athlete> athletes = athleteRepository.findAllById(AidList);    //get athleteList, generic should be Integer
        Set<Athlete> athleteSet = new HashSet<Athlete>(athletes);           //get athleteSet

        List<String>countries = new ArrayList<String>();                    //get the Country List
        for (int i = 0;i<athletes.size();i++){
            countries.add(athletes.get(i).getCountry());
        }

        ResultOfAthletes resultOfAthletes = new ResultOfAthletes(AidList,new ArrayList<Double>(),countries,new ArrayList<Integer>());
        JSONObject resultJSONObj = JSONObject.fromObject(resultOfAthletes);             //finally get resultOfAthletes' json

        Competition competition = new Competition(ajaxRequestBody.getcategoryFirstlayer()
                , ajaxRequestBody.getCategory_secondlayer(), athleteSet, null, "notstarted", resultJSONObj.toString()
                , ajaxRequestBody.getDate(), ajaxRequestBody.getTeamOrindividual());
        competitionRepository.saveAndFlush(competition);
    }

    @RequestMapping(value = "/admin/AddCompetitionTeamTpye", method = RequestMethod.POST)
    @ResponseBody
    public void AddTeamCompetition(@RequestBody AddCompetitionAjaxRequestBody ajaxRequestBody) {
        System.out.println(ajaxRequestBody.toString());
        //get athlete id list
        List<String> TidStringList = (List) JSONArray.toList(JSONArray.fromObject(ajaxRequestBody.getIdcollection()), "", new JsonConfig());
        List<Integer>TidList = new ArrayList<Integer>();
        for (String aTidStringList : TidStringList) {                                           //get aidList. generic is Integer
            TidList.add(Integer.parseInt(aTidStringList));
        }

        List<Team> teams = teamRepository.findAllById(TidList);                                 //get teamList, generic should be Integer
        Set<Team> teamSet = new HashSet<Team>(teams);                                           //get teamSet

        List<String>countries = new ArrayList<String>();                                        //get the Country List
        for (Team team : teams) {
            countries.add(team.getCountry());
        }

        ResultOfTeam resultOfTeam = new ResultOfTeam(TidList,new ArrayList<Double>(),countries,new ArrayList<Integer>());
        JSONObject resultJSONObj = JSONObject.fromObject(resultOfTeam);                         //finally get resultOfTeam' json

        Competition competition = new Competition(ajaxRequestBody.getcategoryFirstlayer()
                , ajaxRequestBody.getCategory_secondlayer(), null, teamSet, "Not started", resultJSONObj.toString()
                , ajaxRequestBody.getDate(), ajaxRequestBody.getTeamOrindividual());
        competitionRepository.saveAndFlush(competition);
    }

    @RequestMapping(value = "/page/SaveCompetitionAthleteTpye", method = RequestMethod.POST)
    @ResponseBody
    public void SaveIndividualCompetition(@RequestBody SaveCompetitionAjaxRequestBody ajaxRequestBody) {
        System.out.println(ajaxRequestBody.toString());

        Competition competition = competitionRepository.findById(ajaxRequestBody.getCid()).get();
        competition.setResult(ajaxRequestBody.getResult());
        competition.setState(ajaxRequestBody.getState());
        competitionRepository.saveAndFlush(competition);
    }
}
