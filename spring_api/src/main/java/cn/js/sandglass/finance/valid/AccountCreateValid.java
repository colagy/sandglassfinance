package cn.js.sandglass.finance.valid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AccountCreateValid {
    private String id;
    @NotNull
    private String  accountbookId;
    @NotNull
    private String accountTypeId;
    @NotNull
    @Min(value = 0)
    private Double balance = 0.00;
    private String mark = "";
    private Integer deleted = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountbookId() {
        return accountbookId;
    }

    public void setAccountbookId(String accountbookId) {
        this.accountbookId = accountbookId;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
