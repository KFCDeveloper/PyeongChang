package com.neu.pyeongchang.ajaxresponsebody;

import com.neu.pyeongchang.model.Athlete;

import java.util.List;

public class AthleteAjaxResponseBody {
    String msg;
    List<Athlete> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Athlete> getResult() {
        return result;
    }

    public void setResult(List<Athlete> result) {
        this.result = result;
    }
}
