package com.neu.pyeongchang.ajaxresponsebody;

public class AddCompetitionAjaxRequestBody {
    private String date;
    private String categoryFirstlayer;
    private String category_secondlayer;
    private String teamOrindividual;
    private String idcollection;

    public AddCompetitionAjaxRequestBody(String date, String categoryFirstlayer, String category_secondlayer, String teamOrindividual, String idcollection) {
        this.date = date;
        this.categoryFirstlayer = categoryFirstlayer;
        this.category_secondlayer = category_secondlayer;
        this.teamOrindividual = teamOrindividual;
        this.idcollection = idcollection;
    }

    public AddCompetitionAjaxRequestBody() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getTeamOrindividual() {
        return teamOrindividual;
    }

    public void setTeamOrindividual(String teamOrindividual) {
        this.teamOrindividual = teamOrindividual;
    }

    public String getIdcollection() {
        return idcollection;
    }

    public void setIdcollection(String idcollection) {
        this.idcollection = idcollection;
    }

    @Override
    public String toString() {
        return "Date : "+ this.date+"\n"+
                "categoryFirstlayer : "+this.categoryFirstlayer+"\n"+
                "Category_SecondLayer : "+this.category_secondlayer+"\n"+
                "TeamOrIndividual : "+this.teamOrindividual+"\n"+
                "IdCollection : "+this.idcollection;

    }
}
