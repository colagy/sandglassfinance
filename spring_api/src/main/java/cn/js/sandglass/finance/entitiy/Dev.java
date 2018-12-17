package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "dev", schema = "sandglassfinance", catalog = "")
public class Dev {

    @Id
    @Column(name = "id", length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Basic
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = true)
    private User user;

}
