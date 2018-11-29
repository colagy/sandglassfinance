package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<AccountEntity, Long> {
}
