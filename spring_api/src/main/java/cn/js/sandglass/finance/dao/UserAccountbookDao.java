package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserAccountbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountbookDao extends JpaRepository<UserAccountbook, Long> {
}
