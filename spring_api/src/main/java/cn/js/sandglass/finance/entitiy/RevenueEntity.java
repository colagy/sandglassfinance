package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "revenue", schema = "sandglassfinance", catalog = "")
public class RevenueEntity {
    private String id;
    private long defaultRevenueType;
    private String revenueTypeId;
    private Timestamp time;
    private Double amount;
    private String mark="";
    private Integer deleted=0;

    @Id
    @Column(name = "id")
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "default_revenue_type",nullable = false)
    public long getDefaultRevenueType() {
        return defaultRevenueType;
    }

    public void setDefaultRevenueType(long defaultRevenueType) {
        this.defaultRevenueType = defaultRevenueType;
    }

    @Basic
    @Column(name = "revenue_type_id",nullable = false)
    public String getRevenueTypeId() {
        return revenueTypeId;
    }

    public void setRevenueTypeId(String revenueTypeId) {
        this.revenueTypeId = revenueTypeId;
    }

    @Basic
    @Column(name = "time",nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "amount",nullable = false, precision = 17, scale = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
        RevenueEntity that = (RevenueEntity) o;
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
