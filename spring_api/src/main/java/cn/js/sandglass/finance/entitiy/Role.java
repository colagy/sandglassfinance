package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "role", schema = "sandglassfinance", catalog = "")
public class Role {

    public static enum Name {
        WECHAT("WECHAT"),
        DEV("DEV"),
        ADMIN("ADMIN");
        public String name;

        Name(String name) {
            this.name = name;
        }
    }

    @Id
    @Column(name = "id", length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private Name name;

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users;

    public String getName() {
        return name.name;
    }
}
