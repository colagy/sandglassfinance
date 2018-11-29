package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfoEntity, Long> {
}
