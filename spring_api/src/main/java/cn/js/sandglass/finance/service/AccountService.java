package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountDao;
import cn.js.sandglass.finance.dao.AccountbookAccountDao;
import cn.js.sandglass.finance.entitiy.AccountEntity;
import cn.js.sandglass.finance.entitiy.AccountbookAccountEntity;
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
    public AccountEntity create(AccountbookAccountEntity accountbookAccountEntity, AccountEntity accountEntity) {
        // 创建账户
        AccountEntity accountRes = save(accountEntity);

        // 创建账本与账户关系
        accountbookAccountEntity.setAccountId(accountRes.getId());
        System.out.println(accountbookAccountEntity.getAccountId());
        accountbookAccountDao.save(accountbookAccountEntity);

        return accountRes;
    }

    public AccountEntity save(AccountEntity accountEntity) {
        AccountEntity accountRes = accountDao.save(accountEntity);
        return accountRes;
    }

    public List<AccountEntity> get(String accountbookId) {

        return accountDao.findAll();
    }

}
