package cn.js.sandglass.finance.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "wechat", schema = "sandglassfinance", catalog = "")
public class Wechat {

    @Id
    @Column(name = "id", length = 36)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name = "unionid", nullable = false, unique = true)
    private String unionid;

    @Basic
    @Column(name = "openid")
    private String openid = "";

    @JsonIgnore
    @Basic
    @Column(name = "deleted")
    private Integer deleted = 0;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

}
