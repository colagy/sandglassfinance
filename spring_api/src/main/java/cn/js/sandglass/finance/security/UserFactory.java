package cn.js.sandglass.finance.security;

import cn.js.sandglass.finance.entitiy.Role;
import cn.js.sandglass.finance.entitiy.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

final class UserFactory {

    private UserFactory() {
    }

    static MyUserDetails create(User user) {
        return new MyUserDetails(
                user.getId(),
                user.getType(),
                user.getUsername(),
                mapToGrantedAuthorities(user.getRoles().stream().map(Role::getName).collect(Collectors.toList())));
    }

    //将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}