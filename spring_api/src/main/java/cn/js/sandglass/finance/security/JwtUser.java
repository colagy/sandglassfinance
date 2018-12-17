package cn.js.sandglass.finance.security;

import cn.js.sandglass.finance.entitiy.Role;
import cn.js.sandglass.finance.entitiy.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {

    private String id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser() {
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
//        authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRoles()));

        authorities = mapToGrantedAuthorities(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
    }

    //将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    // 获取权限信息，目前博主只会拿来存角色。。
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    // 账号是否未过期，默认是false，记得要改一下
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账号是否未锁定，默认是false，记得也要改一下
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 账号凭证是否未过期，默认是false，记得还要改一下
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 这个有点抽象不会翻译，默认也是false，记得改一下
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 我自己重写打印下信息看的
    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}