package cn.js.sandglass.finance.util.response;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

public class RetResponse {

    private final static String SUCCESS = "success";

    public static <T> RetResult<T> ok() {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData((T) JSONObject.parseObject("{}"));
    }

    public static <T> RetResult<T> ok(T data) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RetResult<T> err(int code, String message) {
        if (StringUtils.isEmpty(message)) {
            message = " ";
        }
        return new RetResult<T>().setCode(code).setMsg(message).setData((T) JSONObject.parseObject("{}"));
    }

    public static <T> RetResult<T> err(RetErr retErr) {
        return new RetResult<T>().setCode(retErr.code).setMsg(retErr.msg).setData((T) JSONObject.parseObject("{}"));
    }

    public static <T> RetResult<T> err() {
        return err(RetErr.ERR);
    }

    public static <T> RetResult<T> errController(String msg) {
        RetErr retErr = RetErr.CONTROLLER_ERR;
        return new RetResult<T>().setCode(retErr.code).setMsg(msg).setData((T) JSONObject.parseObject("{}"));
    }

    public static <T> RetResult<T> errService(String msg) {
        RetErr retErr = RetErr.SERVICE_ERR;
        return new RetResult<T>().setCode(retErr.code).setMsg(msg).setData((T) JSONObject.parseObject("{}"));
    }

    public static <T> RetResult<T> res(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData((T) new JSONObject());
    }

    public static <T> RetResult<T> res(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}