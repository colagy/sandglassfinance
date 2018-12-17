package cn.js.sandglass.finance.util.response;

public enum RetErr {

    ERR(6400, "未知错误"),

    CONTROLLER_ERR(6401, "控制器错误"),

    SERVICE_ERR(6402, "服务错误"),

    ALREADY_EXIST(6403, "已经存在"),

    NOT_EXIST(6404, "不存在"),

    OTHER(6405, "其他错误");

    public int code;

    public String msg;

    RetErr(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
