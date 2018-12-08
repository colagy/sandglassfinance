package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_expenditure", schema = "sandglassfinance", catalog = "")
public class AccountExpenditure {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Basic
    @Column(name = "expenditure_id", nullable = false)
    private String expenditureId;

    @Basic
    @Column(name = "mark")
    private String mark = "";

    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public String getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(String expenditureId) {
        this.expenditureId = expenditureId;
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
        AccountExpenditure that = (AccountExpenditure) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(expenditureId, that.expenditureId) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountId, expenditureId, mark, deleted);
    }
}
