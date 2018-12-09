package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "expenditure", schema = "sandglassfinance", catalog = "")
public class Expenditure {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;

    @Basic
    @Column(name = "default_expenditure_type",nullable = false)
    private long defaultExpenditureType;

    @Basic
    @Column(name = "expenditure_type_id",nullable = false)
    private String expenditureTypeId;

    @Basic
    @Column(name = "time",nullable = false)
    private Timestamp time;

    @Basic
    @Column(name = "amount",nullable = false)
    private long amount;

    @Basic
    @Column(name = "mark")
    private String mark="";

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted=0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

}
