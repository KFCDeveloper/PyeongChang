package com.neu.pyeongchang.ajaxresponsebody;

public class SaveCompetitionAjaxRequestBody {
    private String categoryFirstlayer;
    private String category_secondlayer;
    private int cid;
    private String date;
    private String result;
    private String state;
    private String teamOrindividual;

    public SaveCompetitionAjaxRequestBody() {
    }

    public SaveCompetitionAjaxRequestBody(String categoryFirstlayer, String category_secondlayer, int cid, String date, String result, String state, String teamOrindividual) {
        this.categoryFirstlayer = categoryFirstlayer;
        this.category_secondlayer = category_secondlayer;
        this.cid = cid;
        this.date = date;
        this.result = result;
        this.state = state;
        this.teamOrindividual = teamOrindividual;
    }

    public String getcategoryFirstlayer() {
        return categoryFirstlayer;
    }

    public void setcategoryFirstlayer(String categoryFirstlayer) {
        this.categoryFirstlayer = categoryFirstlayer;
    }

    public String getCategory_secondlayer() {
        return category_secondlayer;
    }

    public void setCategory_secondlayer(String category_secondlayer) {
        this.category_secondlayer = category_secondlayer;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTeamOrindividual() {
        return teamOrindividual;
    }

    public void setTeamOrindividual(String teamOrindividual) {
        this.teamOrindividual = teamOrindividual;
    }

    @Override
    public String toString() {
        return "SaveCompetitionAjaxRequestBody{" +
                "categoryFirstlayer='" + categoryFirstlayer + '\'' +
                ", category_secondlayer='" + category_secondlayer + '\'' +
                ", cid=" + cid +
                ", date='" + date + '\'' +
                ", result='" + result + '\'' +
                ", state='" + state + '\'' +
                ", teamOrindividual='" + teamOrindividual + '\'' +
                '}';
    }
}
