package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserDevEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDevDao extends JpaRepository<UserDevEntity, Long> {

    public UserDevEntity findByUsernameAndPassword(String username,String password);

}
