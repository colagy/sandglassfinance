package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
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

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted=0;

}
