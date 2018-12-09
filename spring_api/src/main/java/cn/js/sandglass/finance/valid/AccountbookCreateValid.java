package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;

public class AccountbookCreateValid {
    @NotNull
    private String name;
    private String mark="";

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
