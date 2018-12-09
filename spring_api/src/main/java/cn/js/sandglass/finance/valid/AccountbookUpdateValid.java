package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;

public class AccountbookUpdateValid {
    @NotNull(message = "账本id不可为空")
    private String id;
    private String name;
    private String mark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
