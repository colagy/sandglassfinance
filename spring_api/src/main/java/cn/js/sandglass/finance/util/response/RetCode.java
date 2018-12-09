package cn.js.sandglass.finance.util.response;

public enum RetCode {

    // 成功
    SUCCESS(6201),

    // 失败
    FAIL(6400),

    // 未认证（签名错误）
    UNAUTHORIZED(6401),

    // 接口不存在
    NOT_FOUND(6404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(6500);

    public int code;

    RetCode(int code) {
        this.code = code;
    }
}