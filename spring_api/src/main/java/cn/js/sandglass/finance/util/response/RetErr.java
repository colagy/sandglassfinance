package cn.js.sandglass.finance.util.response;

public enum RetErr {

    ERR(4400, "请求错误"),

    ALREADY_EXIST(4401, "已经存在"),

    NOT_EXIST(4402, "不存在");

    public int code;

    public String msg;

    RetErr(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
