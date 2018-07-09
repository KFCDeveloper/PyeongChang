package com.neu.pyeongchang.NoModelJavaBean;

import java.util.List;

public class ResultOfAthletes {
    private List<Integer> AthleteIds;
    private List<Double> Grade;
    private List<String> Country;
    private List<Integer> Medal;     //[Gold,silver,Bronze] mapped [0,1,2]

    public ResultOfAthletes() {
    }

    public ResultOfAthletes(List<Integer> athleteIds, List<Double> grade, List<String> country, List<Integer> medal) {
        AthleteIds = athleteIds;
        Grade = grade;
        Country = country;
        Medal = medal;
    }

    public List<Integer> getAthleteIds() {
        return AthleteIds;
    }

    public void setAthleteIds(List<Integer> athleteIds) {
        AthleteIds = athleteIds;
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
