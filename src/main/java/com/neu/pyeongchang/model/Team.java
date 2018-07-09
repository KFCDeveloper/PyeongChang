package com.neu.pyeongchang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private int tid;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "tid")
    private Set<Athlete>athleteSet;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "team_mapping_competition",joinColumns = @JoinColumn(name = "tid"),inverseJoinColumns = @JoinColumn(name = "cid"))
    private Set<Competition> competitions;

    @Column(name = "country")
    private  String country;

    @Column(name = "bestresult")
    private String bestresult;

    @Column(name = "information")
    private String information;

    public Team() {
    }

    public Team(Set<Athlete> athleteSet, Set<Competition> competitions, String country, String bestresult, String information) {
        this.athleteSet = athleteSet;
        this.competitions = competitions;
        this.country = country;
        this.bestresult = bestresult;
        this.information = information;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Set<Athlete> getAthleteSet() {
        return athleteSet;
    }

    public void setAthleteSet(Set<Athlete> athleteSet) {
        this.athleteSet = athleteSet;
    }

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBestresult() {
        return bestresult;
    }

    public void setBestresult(String bestresult) {
        this.bestresult = bestresult;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
