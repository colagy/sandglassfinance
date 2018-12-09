package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "sandglassfinance", catalog = "")
public class Account {

    @Id
    @Column(name = "id", length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "balance", nullable = false, precision = 17, scale = 2)
    private Double balance;

    @Basic
    @Column(name = "mark")
    private String mark = "";

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "accountbook_id")
    private Accountbook accountbook;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public Accountbook getAccountbook() {
        return accountbook;
    }

    public void setAccountbook(Accountbook accountbook) {
        this.accountbook = accountbook;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
