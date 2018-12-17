package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "account_type", schema = "sandglassfinance", catalog = "")
public class AccountType {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;

    @Basic
    @Column(name = "type",nullable = false)
    private String type;

    @Basic
    @Column(name = "classify",nullable = false)
    private Integer classify=0; // 0,现金账户 1,资产账户 2,负债账户

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

    @JsonIgnore
    @OneToMany(mappedBy = "accountType")
    private List<Account> accounts=new ArrayList<>();

}
