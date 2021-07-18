package com.gf.ip;

import java.util.List;

public class IpResult {


    private Integer code;
    private List<IpData> data;
    private String msg;
    private Boolean success;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<IpData> getData() {
        return data;
    }

    public void setData(List<IpData> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
