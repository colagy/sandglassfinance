package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.AccountExpenditureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountExpenditureDao extends JpaRepository<AccountExpenditureEntity, Long> {
}
