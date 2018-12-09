package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
    Account findById(String id);
}
