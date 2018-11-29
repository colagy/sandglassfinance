package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "accountbook_account", schema = "sandglassfinance", catalog = "")
public class AccountbookAccountEntity {
    private String id;
    private String accountbookId;
    private String accountId="";
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
    @Column(name = "accountbook_id", nullable = false)
    public String getAccountbookId() {
        return accountbookId;
    }

    public void setAccountbookId(String accountbookId) {
        this.accountbookId = accountbookId;
    }

    @Basic
    @Column(name = "account_id")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
        AccountbookAccountEntity that = (AccountbookAccountEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountbookId, that.accountbookId) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountbookId, accountId, deleted);
    }
}
