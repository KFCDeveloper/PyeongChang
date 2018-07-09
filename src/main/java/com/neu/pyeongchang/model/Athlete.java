package com.neu.pyeongchang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "athlete")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private int aid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "tid")
    private Team team;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "athlete_mapping_competition", joinColumns = @JoinColumn(name = "aid"), inverseJoinColumns = @JoinColumn(name = "cid"))
    private Set<Competition> competitions;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @Column(name = "gender")
    private String gender;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @Column(name = "best_result")
    private String bestResult;

    public Athlete() {
    }

    public Athlete(Team team, Set<Competition> competitions, String name, String picture, String gender, String country, String description, String bestResult) {
        this.team = team;
        this.competitions = competitions;
        this.name = name;
        this.picture = picture;
        this.gender = gender;
        this.country = country;
        this.description = description;
        this.bestResult = bestResult;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBestResult() {
        return bestResult;
    }

    public void setBestResult(String bestResult) {
        this.bestResult = bestResult;
    }

}