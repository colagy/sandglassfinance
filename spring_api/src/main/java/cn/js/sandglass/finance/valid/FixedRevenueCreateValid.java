package cn.js.sandglass.finance.valid;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class FixedRevenueCreateValid {
    private String id;
    @NotNull
    private long defaultRevenueType;
    @NotNull
    private String revenueTypeId;
    @NotNull
    private String timeUnit;
    private String month = "";
    private String day = "";
    private String week = "";
    @NotNull
    private Timestamp startTime;
    @NotNull
    private Timestamp endTime;
    @NotNull
    private long amount;
    private String mark = "";

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

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
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
