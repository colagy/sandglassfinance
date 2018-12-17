package cn.js.sandglass.finance.valid;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginValid {
    @NotNull
    private String username;
    @NotNull
    private String password;
    private Integer rememberMe;
}