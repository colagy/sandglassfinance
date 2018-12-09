package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_dev", schema = "sandglassfinance", catalog = "")
public class UserDev {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "uid", nullable = false, unique = true)
    private String uid;

    @Basic
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @JsonIgnore
    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    public UserDev() {
    }

    public UserDev(String id, String uid, String username, String password) {
        this.id = id;
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

}
