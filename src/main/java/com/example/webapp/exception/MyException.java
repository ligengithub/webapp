package com.example.webapp.exception;

import java.util.HashMap;
import java.util.Map;

public class MyException extends Exception {

    private static final long serialVersionUID = -238091758285157331L;

    private String errCode;
    private String errMsg;

    public MyException() {
        super();
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(String _errCode) {
        this.errCode = _errCode;
        this.errMsg = getMsgByCode(_errCode);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    //
    public static final String CODE_NULL_ERROR = "1001";
    public static final String MSG_NULL_ERROR = "空指针异常";
    public static final String CODE_PARAM_NULL = "1002";
    public static final String MSG_PARAM_NULL = "参数异常";
    public static final String CODE_SQL_ERROR = "1003";
    public static final String MSG_SQL_ERROR = "sql异常";
    public static final String CODE_DATA_REPEAT_ERROR = "1004";
    public static final String MSG_DATA_REPEAT_ERROR = "数据重复异常";
    public static final String CODE_DATA_TOO_LONG_ERROR = "1005";
    public static final String MSG_DATA_TOO_LONG_ERROR = "数据长度超出异常";
    public static final String CODE_UNKNOWN_ERROR = "1006";
    public static final String MSG_UNKNOWN_ERROR = "未知异常";
    public static final String CODE_AUTH_ERROR = "1007";
    public static final String MSG_AUTH_ERROR = "认证异常";

    //endregion

    //根据code获取msg
    private static Map<String, String> msgMap = new HashMap<>();

    public static String getMsgByCode(String code) {
        return msgMap.get(code);
    }

    static {
        // region 公共返回码
        msgMap.put(CODE_NULL_ERROR, MSG_NULL_ERROR);
        msgMap.put(CODE_PARAM_NULL, MSG_PARAM_NULL);
        msgMap.put(CODE_SQL_ERROR, MSG_SQL_ERROR);
        msgMap.put(CODE_DATA_REPEAT_ERROR, MSG_DATA_REPEAT_ERROR);
        msgMap.put(CODE_DATA_TOO_LONG_ERROR, MSG_DATA_TOO_LONG_ERROR);
        msgMap.put(CODE_UNKNOWN_ERROR, MSG_UNKNOWN_ERROR);
        msgMap.put(CODE_AUTH_ERROR, MSG_AUTH_ERROR);
    }

}
