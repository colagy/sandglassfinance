package cn.js.sandglass.finance.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {

    //返回分配给用户的角色列表
    Collection<? extends GrantedAuthority> getAuthorities();

    //返回密码
    String getPassword();

    //返回帐号
    String getUsername();

    // 账户是否未过期
    boolean isAccountNonExpired();

    // 账户是否未锁定
    boolean isAccountNonLocked();

    // 密码是否未过期
    boolean isCredentialsNonExpired();

    // 账户是否激活
    boolean isEnabled();
}