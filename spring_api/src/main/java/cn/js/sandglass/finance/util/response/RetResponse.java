package cn.js.sandglass.finance.util.response;

import com.alibaba.fastjson.JSONObject;

public class RetResponse {

    private final static String SUCCESS = "success";

    public static <T> RetResult<T> ok() {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData((T) new JSONObject());
    }

    public static <T> RetResult<T> ok(T data) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RetResult<T> err(int code,String message) {
        return new RetResult<T>().setCode(code).setMsg(message);
    }

    public static <T> RetResult<T> err(RetErr retErr){
        return new RetResult<T>().setCode(retErr.code).setMsg(retErr.msg).setData((T) new JSONObject());
    }

    public static <T> RetResult<T> res(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData((T) new JSONObject());
    }

    public static <T> RetResult<T> res(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}