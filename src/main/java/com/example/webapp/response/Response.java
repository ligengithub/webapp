package com.example.webapp.response;

import lombok.Data;

import java.util.HashMap;

/**
 * @author ligen
 * @title: Response
 * @projectName webapp
 * @description:
 * @date 2020/11/1120:53
 */
@Data
public class Response<T> {

    private String code;
    private String msg;
    private T data;

    public static final String CODE_SUCCESS = "2001";
    public static final String MSG_SUCCESS = "操作成功";

    public static final String CODE_FAIL = "4001";
    public static final String MSG_FAIL = "操作失败";

    private static HashMap<String, String> result = new HashMap<String, String>();

    static {
        result.put(CODE_SUCCESS, MSG_SUCCESS);
        result.put(CODE_FAIL, MSG_FAIL);
    }


    public Response(String code) {
        this.code = code;
        this.msg = result.get(code);
    }

    public Response(String code, T data) {
        this.code = code;
        this.msg = result.get(code);
        this.data = data;
    }

}
