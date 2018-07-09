package com.neu.pyeongchang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "competition")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private int cid;

    @Column(name = "category_firstlayer")
    private String categoryFirstlayer;

    @Column(name = "category_secondlayer")
    private String category_secondlayer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "athlete_mapping_competition", joinColumns = @JoinColumn(name = "cid"), inverseJoinColumns = @JoinColumn(name = "aid"))
    private Set<Athlete> athleteList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "team_mapping_competition", joinColumns = @JoinColumn(name = "cid"), inverseJoinColumns = @JoinColumn(name = "tid"))
    private Set<Team> teamList;

    @Column(name = "state")
    private String state;

    @Column(name = "result")
    private String result;

    @Column(name = "date")
    private String date;

    @Column(name = "teamOrindividual")
    private String teamOrindividual;

    public Competition() {
    }

    public Competition(String categoryFirstlayer, String category_secondlayer, Set<Athlete> athleteList, Set<Team> teamList, String state, String result, String date, String teamOrindividual) {
        this.categoryFirstlayer = categoryFirstlayer;
        this.category_secondlayer = category_secondlayer;
        this.athleteList = athleteList;
        this.teamList = teamList;
        this.state = state;
        this.result = result;
        this.date = date;
        this.teamOrindividual = teamOrindividual;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCategoryFirstlayer() {
        return categoryFirstlayer;
    }

    public void setCategoryFirstlayer(String categoryFirstlayer) {
        this.categoryFirstlayer = categoryFirstlayer;
    }

    public String getCategory_secondlayer() {
        return category_secondlayer;
    }

    public void setCategory_secondlayer(String category_secondlayer) {
        this.category_secondlayer = category_secondlayer;
    }

    public Set<Athlete> getAthleteList() {
        return athleteList;
    }

    public void setAthleteList(Set<Athlete> athleteList) {
        this.athleteList = athleteList;
    }

    public Set<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(Set<Team> teamList) {
        this.teamList = teamList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeamOrindividual() {
        return teamOrindividual;
    }

    public void setTeamOrindividual(String teamOrindividual) {
        this.teamOrindividual = teamOrindividual;
    }
}
