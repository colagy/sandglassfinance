package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_fixed_revenue", schema = "sandglassfinance", catalog = "")
public class AccountFixedRevenueEntity {
    private String id;
    private String accountId;
    private String fixedRevenueId;
    private String mark = "";
    private Integer deleted = 0;

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id", nullable = false)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "fixed_revenue_id", nullable = false)
    public String getFixedRevenueId() {
        return fixedRevenueId;
    }

    public void setFixedRevenueId(String fixedRevenueId) {
        this.fixedRevenueId = fixedRevenueId;
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
        AccountFixedRevenueEntity that = (AccountFixedRevenueEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(fixedRevenueId, that.fixedRevenueId) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountId, fixedRevenueId, mark, deleted);
    }
}
