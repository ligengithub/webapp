package com.example.webapp.po;

/**
 * @author ligen
 * @title: Result
 * @projectName webapp
 * @description:
 * @date 2020/4/2718:42
 */
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public Result(String code) {
        this.code = code;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.data = t;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return data;
    }

    public void setT(T t) {
        this.data = t;
    }
}
