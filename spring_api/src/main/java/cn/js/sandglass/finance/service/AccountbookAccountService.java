package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountbookAccountDao;
import cn.js.sandglass.finance.entitiy.AccountbookAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountbookAccountService {

    @Autowired
    private AccountbookAccountDao accountbookAccountDao;

    public AccountbookAccount save(AccountbookAccount accountbookAccount) {
        return accountbookAccountDao.save(accountbookAccount);
    }
}
