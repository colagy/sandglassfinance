package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "expenditure", schema = "sandglassfinance", catalog = "")
public class ExpenditureEntity {
    private String id;
    private long defaultExpenditureType;
    private String expenditureTypeId;
    private Timestamp time;
    private long amount;
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
    @Column(name = "default_expenditure_type",nullable = false)
    public long getDefaultExpenditureType() {
        return defaultExpenditureType;
    }

    public void setDefaultExpenditureType(long defaultExpenditureType) {
        this.defaultExpenditureType = defaultExpenditureType;
    }

    @Basic
    @Column(name = "expenditure_type_id",nullable = false)
    public String getExpenditureTypeId() {
        return expenditureTypeId;
    }

    public void setExpenditureTypeId(String expenditureTypeId) {
        this.expenditureTypeId = expenditureTypeId;
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
    @Column(name = "amount",nullable = false)
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
        ExpenditureEntity that = (ExpenditureEntity) o;
        return defaultExpenditureType == that.defaultExpenditureType &&
                amount == that.amount &&
                Objects.equals(id, that.id) &&
                Objects.equals(expenditureTypeId, that.expenditureTypeId) &&
                Objects.equals(time, that.time) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, defaultExpenditureType, expenditureTypeId, time, amount, mark, deleted);
    }
}
