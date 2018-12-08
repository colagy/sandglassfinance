package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "fixed_expenditure", schema = "sandglassfinance", catalog = "")
public class FixedExpenditure {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "default_expenditure_type", nullable = false)
    private long defaultExpenditureType;

    @Basic
    @Column(name = "expenditure_type_id", nullable = false)
    private String expenditureTypeId;

    @Basic
    @Column(name = "time_unit", nullable = false)
    private String timeUnit;

    @Basic
    @Column(name = "month")
    private String month = "";

    @Basic
    @Column(name = "day")
    private String day = "";

    @Basic
    @Column(name = "week")
    private String week = "";

    @Basic
    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Basic
    @Column(name = "end_time", nullable = false)
    private Timestamp endTime;

    @Basic
    @Column(name = "amount")
    private long amount;

    @Basic
    @Column(name = "mark")
    private String mark = "";

    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getDefaultExpenditureType() {
        return defaultExpenditureType;
    }

    public void setDefaultExpenditureType(long defaultFixedExpenditureType) {
        this.defaultExpenditureType = defaultFixedExpenditureType;
    }

    public String getExpenditureTypeId() {
        return expenditureTypeId;
    }

    public void setExpenditureTypeId(String expenditureTypeId) {
        this.expenditureTypeId = expenditureTypeId;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedExpenditure that = (FixedExpenditure) o;
        return defaultExpenditureType == that.defaultExpenditureType &&
                amount == that.amount &&
                Objects.equals(id, that.id) &&
                Objects.equals(expenditureTypeId, that.expenditureTypeId) &&
                Objects.equals(timeUnit, that.timeUnit) &&
                Objects.equals(month, that.month) &&
                Objects.equals(day, that.day) &&
                Objects.equals(week, that.week) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, defaultExpenditureType, expenditureTypeId, timeUnit, month, day, week, startTime, endTime, amount, mark, deleted);
    }
}
