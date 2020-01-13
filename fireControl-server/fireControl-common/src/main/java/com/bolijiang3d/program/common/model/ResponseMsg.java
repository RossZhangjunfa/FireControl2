package com.bolijiang3d.program.common.model;


import java.io.Serializable;
import java.util.Map;

public class ResponseMsg<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    private Map<String,Object> param;

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public ResponseMsg(){}

    public ResponseMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseMsg(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseMsg(int code, String msg, T data, Map<String, Object> param) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.param = param;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
