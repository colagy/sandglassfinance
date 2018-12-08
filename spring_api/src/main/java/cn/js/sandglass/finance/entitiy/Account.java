package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "sandglassfinance", catalog = "")
public class Account {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "account_type_id",nullable = false)
    private String accountTypeId;

    @Basic
    @Column(name = "balance",nullable = false, precision = 17, scale = 2)
    private Double balance;

    @Basic
    @Column(name = "mark")
    private String mark = "";

    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "accountbook_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Accountbook accountbook;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return accountTypeId == that.accountTypeId &&
                Objects.equals(id, that.id) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountTypeId, balance, mark, deleted);
    }

}
