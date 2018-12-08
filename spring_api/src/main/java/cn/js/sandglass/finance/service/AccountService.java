package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountDao;
import cn.js.sandglass.finance.dao.AccountbookAccountDao;
import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.AccountbookAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountbookAccountDao accountbookAccountDao;

    @Autowired
    private AccountbookService accountbookService;

    @Autowired
    private AccountbookAccountService accountbookAccountService;

    @Transactional
    public Account create(AccountbookAccount accountbookAccount, Account account) {
        // 创建账户
        Account accountRes = save(account);

        // 创建账本与账户关系
        accountbookAccount.setAccountId(accountRes.getId());
        System.out.println(accountbookAccount.getAccountId());
        accountbookAccountDao.save(accountbookAccount);

        return accountRes;
    }

    public Account save(Account account) {
        Account accountRes = accountDao.save(account);
        return accountRes;
    }

    public List<Account> get(String accountbookId) {

        return accountDao.findAll();
    }

}
