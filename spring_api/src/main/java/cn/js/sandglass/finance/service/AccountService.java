package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountDao;
import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.Accountbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public Account create( Account account) {
        return save(account);
    }

    public Account save(Account account) {
        Account accountRes = accountDao.save(account);
        return accountRes;
    }

    public Account update(Account account){
        return save(account);
    }

    public Account get(String id){
        return accountDao.findById(id);
    }

    public List<Account> list(String accountbookId) {
        return accountDao.findAll();
    }

}
