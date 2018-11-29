package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<UserEntity, Long> {

    public List<UserEntity> findByUnionid(String unionid);

}
