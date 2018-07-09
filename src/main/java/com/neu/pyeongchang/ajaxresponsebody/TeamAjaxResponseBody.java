package com.neu.pyeongchang.ajaxresponsebody;

import com.neu.pyeongchang.model.Team;

import java.util.List;

public class TeamAjaxResponseBody {
    String msg;
    List<Team> result;

    public TeamAjaxResponseBody() {
    }

    public TeamAjaxResponseBody(String msg, List<Team> result) {
        this.msg = msg;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Team> getResult() {
        return result;
    }

    public void setResult(List<Team> result) {
        this.result = result;
    }
}
