package com.neu.pyeongchang.ajaxresponsebody;

import com.neu.pyeongchang.model.Competition;

import java.util.List;

public class CompetitionAjaxResponseBody {
    String msg;
    List<Competition> result;

    public CompetitionAjaxResponseBody() {
    }

    public CompetitionAjaxResponseBody(String msg, List<Competition> result) {
        this.msg = msg;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Competition> getResult() {
        return result;
    }

    public void setResult(List<Competition> result) {
        this.result = result;
    }
}
