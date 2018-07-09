package com.neu.pyeongchang.NoModelJavaBean;

import java.util.List;

public class ResultOfTeam {
    private List<Integer> TeamIds;
    private List<Double> Grade;
    private List<String> Country;
    private List<Integer> Medal;     //[Gold,silver,Bronze] mapped [0,1,2]

    public ResultOfTeam() {
    }

    public ResultOfTeam(List<Integer> teamIds, List<Double> grade, List<String> country, List<Integer> medal) {
        TeamIds = teamIds;
        Grade = grade;
        Country = country;
        Medal = medal;
    }

    public List<Integer> getTeamIds() {
        return TeamIds;
    }

    public void setTeamIds(List<Integer> teamIds) {
        TeamIds = teamIds;
    }

    public List<Double> getGrade() {
        return Grade;
    }

    public void setGrade(List<Double> grade) {
        Grade = grade;
    }

    public List<String> getCountry() {
        return Country;
    }

    public void setCountry(List<String> country) {
        Country = country;
    }

    public List<Integer> getMedal() {
        return Medal;
    }

    public void setMedal(List<Integer> medal) {
        Medal = medal;
    }
}
