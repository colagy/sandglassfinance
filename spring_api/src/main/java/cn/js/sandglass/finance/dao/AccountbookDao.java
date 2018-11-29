package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.AccountbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountbookDao extends JpaRepository<AccountbookEntity, Long> {

    AccountbookEntity findById(String id);

}