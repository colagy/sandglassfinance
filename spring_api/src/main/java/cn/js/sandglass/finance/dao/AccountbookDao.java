package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.Accountbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountbookDao extends JpaRepository<Accountbook, Long> {

    Accountbook findById(String id);
    List<Account> findAccountsById(String id);

}