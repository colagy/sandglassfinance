package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
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

}
