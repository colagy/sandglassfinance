package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;

public class AccountbookDeleteValid {
    @NotNull(message = "账本id不可为空")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
