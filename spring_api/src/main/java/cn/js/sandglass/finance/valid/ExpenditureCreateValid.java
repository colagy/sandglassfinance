package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class ExpenditureCreateValid {
    private String id;
    @NotNull
    private long defaultExpenditureType;
    @NotNull
    private String expenditureTypeId;
    @NotNull
    private Timestamp time;
    @NotNull
    private long amount;
    private String mark="";

    @NotNull
    private String accountId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getDefaultExpenditureType() {
        return defaultExpenditureType;
    }

    public void setDefaultExpenditureType(long defaultExpenditureType) {
        this.defaultExpenditureType = defaultExpenditureType;
    }

    public String getExpenditureTypeId() {
        return expenditureTypeId;
    }

    public void setExpenditureTypeId(String expenditureTypeId) {
        this.expenditureTypeId = expenditureTypeId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
