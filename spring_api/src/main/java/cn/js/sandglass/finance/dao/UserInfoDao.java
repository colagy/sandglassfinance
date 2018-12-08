package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
}
