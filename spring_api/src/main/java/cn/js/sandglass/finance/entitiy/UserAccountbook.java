package cn.js.sandglass.finance.entitiy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_accountbook", schema = "sandglassfinance", catalog = "")
public class UserAccountbook {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;

    @Basic
    @Column(name = "user_id",nullable = false)
    private String userId;

    @Basic
    @Column(name = "accountbookId",nullable = false)
    private String accountbookId;

    @Basic
    @Column(name = "mark")
    private String mark="";

    @Basic
    @Column(name = "deleted")
    private Integer deleted=0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return accountbookId;
    }

    public void setName(String accountbookId) {
        this.accountbookId = accountbookId;
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
        UserAccountbook that = (UserAccountbook) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(accountbookId, that.accountbookId) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, accountbookId, mark, deleted);
    }
}
