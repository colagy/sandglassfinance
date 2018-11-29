package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserAccountbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountbookDao extends JpaRepository<UserAccountbookEntity, Long> {
}
