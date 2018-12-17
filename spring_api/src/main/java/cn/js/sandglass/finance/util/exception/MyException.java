package cn.js.sandglass.finance.util.exception;

import cn.js.sandglass.finance.util.response.RetErr;

public class MyException extends RuntimeException {

    private Integer code;

    public MyException(RetErr retErr) {
        super(retErr.msg);
        this.code = retErr.code;
    }

    public MyException(String msg) {
        super(msg);
        RetErr retErr = RetErr.OTHER;
        retErr.msg = msg;
        this.code = retErr.code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}