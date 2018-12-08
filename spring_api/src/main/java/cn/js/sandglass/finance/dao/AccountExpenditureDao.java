package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.AccountExpenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountExpenditureDao extends JpaRepository<AccountExpenditure, Long> {
}
