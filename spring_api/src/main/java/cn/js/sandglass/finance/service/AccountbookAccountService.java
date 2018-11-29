package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountbookAccountDao;
import cn.js.sandglass.finance.entitiy.AccountbookAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountbookAccountService {

    @Autowired
    private AccountbookAccountDao accountbookAccountDao;

    public AccountbookAccountEntity save(AccountbookAccountEntity accountbookAccountEntity) {
        return accountbookAccountDao.save(accountbookAccountEntity);
    }
}
