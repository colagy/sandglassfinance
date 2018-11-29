package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "fixed_revenue", schema = "sandglassfinance", catalog = "")
public class FixedRevenueEntity {
    private String id;
    private long defaultRevenueType;
    private String revenueTypeId;
    private String timeUnit;
    private String month = "";
    private String day = "";
    private String week = "";
    private Timestamp startTime;
    private Timestamp endTime;
    private long amount;
    private String mark = "";
    private Integer deleted = 0;

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "default_revenue_type", nullable = false)
    public long getDefaultRevenueType() {
        return defaultRevenueType;
    }

    public void setDefaultRevenueType(long defaultFixedRevenueType) {
        this.defaultRevenueType = defaultFixedRevenueType;
    }

    @Basic
    @Column(name = "revenue_type_id", nullable = false)
    public String getRevenueTypeId() {
        return revenueTypeId;
    }

    public void setRevenueTypeId(String revenueTypeId) {
        this.revenueTypeId = revenueTypeId;
    }

    @Basic
    @Column(name = "time_unit", nullable = false)
    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    @Basic
    @Column(name = "month")
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Basic
    @Column(name = "day")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Basic
    @Column(name = "week")
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Basic
    @Column(name = "start_time", nullable = false)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = false)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "amount")
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "mark")
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "deleted")
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
        FixedRevenueEntity that = (FixedRevenueEntity) o;
        return defaultRevenueType == that.defaultRevenueType &&
                amount == that.amount &&
                Objects.equals(id, that.id) &&
                Objects.equals(revenueTypeId, that.revenueTypeId) &&
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

        return Objects.hash(id, defaultRevenueType, revenueTypeId, timeUnit, month, day, week, startTime, endTime, amount, mark, deleted);
    }
}
