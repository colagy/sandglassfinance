package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;

public class LoginWeappSessionValid {
    @NotNull
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
