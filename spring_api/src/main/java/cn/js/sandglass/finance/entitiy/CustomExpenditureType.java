package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "custom_expenditure_type", schema = "sandglassfinance", catalog = "")
public class CustomExpenditureType {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;

    @Basic
    @Column(name = "mark")
    private String mark="";

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted=0;

}
