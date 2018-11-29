package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;

public class LoginWeappValid {
    @NotNull
    private String sessionKey;
    @NotNull
    private String encryptedData;
    @NotNull
    private String iv;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
