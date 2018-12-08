package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserDev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDevDao extends JpaRepository<UserDev, Long> {

    public UserDev findByUsernameAndPassword(String username, String password);

    public UserDev findByUsername(String username);

}
