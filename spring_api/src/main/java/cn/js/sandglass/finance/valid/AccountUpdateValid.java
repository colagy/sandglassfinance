package cn.js.sandglass.finance.valid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AccountUpdateValid {
    @NotNull
    @Min(value = 0)
    private Double balance = 0.00;
    private String mark = "";

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
