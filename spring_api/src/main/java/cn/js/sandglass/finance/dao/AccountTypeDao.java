package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.AccountTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeDao extends JpaRepository<AccountTypeEntity, Long> {
}
