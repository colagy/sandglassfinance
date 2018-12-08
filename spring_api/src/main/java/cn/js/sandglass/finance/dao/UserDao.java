package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    public User findById(String id);

}
