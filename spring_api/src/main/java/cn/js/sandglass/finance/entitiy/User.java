package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "user", schema = "sandglassfinance", catalog = "")
public class User implements Serializable {

    @Id
    @Column(name = "id", length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "username", nullable = false, unique = true)
    private String username; // wechat,微信 dev,开发者

    @JsonIgnore
    @Basic
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    @JsonIgnore
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Role> roles;
}
