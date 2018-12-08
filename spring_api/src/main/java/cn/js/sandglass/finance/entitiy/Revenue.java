package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "revenue", schema = "sandglassfinance", catalog = "")
public class Revenue {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;

    @Basic
    @Column(name = "default_revenue_type",nullable = false)
    private long defaultRevenueType;

    @Basic
    @Column(name = "revenue_type_id",nullable = false)
    private String revenueTypeId;

    @Basic
    @Column(name = "time",nullable = false)
    private Timestamp time;

    @Basic
    @Column(name = "amount",nullable = false, precision = 17, scale = 2)
    private Double amount;

    @Basic
    @Column(name = "mark")
    private String mark="";

    @Basic
    @Column(name = "deleted")
    private Integer deleted=0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue that = (Revenue) o;
        return defaultRevenueType == that.defaultRevenueType &&
                amount == that.amount &&
                Objects.equals(id, that.id) &&
                Objects.equals(revenueTypeId, that.revenueTypeId) &&
                Objects.equals(time, that.time) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, defaultRevenueType, revenueTypeId, time, amount, mark, deleted);
    }
}
