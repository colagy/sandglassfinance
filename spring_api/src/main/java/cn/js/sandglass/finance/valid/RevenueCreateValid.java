package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class RevenueCreateValid {
    private String id;
    @NotNull
    private long defaultRevenueType;
    @NotNull
    private String revenueTypeId;
    @NotNull
    private Timestamp time;
    @NotNull
    private Double amount;
    private String mark="";
    private Integer deleted=0;

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

    public long getDefaultRevenueType() {
        return defaultRevenueType;
    }

    public void setDefaultRevenueType(long defaultRevenueType) {
        this.defaultRevenueType = defaultRevenueType;
    }

    public String getRevenueTypeId() {
        return revenueTypeId;
    }

    public void setRevenueTypeId(String revenueTypeId) {
        this.revenueTypeId = revenueTypeId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
