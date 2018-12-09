package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountTypeDao;
import cn.js.sandglass.finance.entitiy.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeService {

    @Autowired
    AccountTypeDao accountTypeDao;

    public AccountType save(AccountType accountType) {
        return accountTypeDao.save(accountType);
    }

    public List<AccountType> list() {
        return accountTypeDao.findAll();
    }

    public AccountType get(String id) {
        return accountTypeDao.findById(id);
    }

}
