package cn.js.sandglass.finance.util.response;

public enum RetErr {

    ERR(6400, "未知错误"),

    ALREADY_EXIST(6403, "已经存在"),

    NOT_EXIST(6404, "不存在");

    public int code;

    public String msg;

    RetErr(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
