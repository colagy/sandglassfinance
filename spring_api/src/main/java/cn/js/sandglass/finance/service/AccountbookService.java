package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountbookDao;
import cn.js.sandglass.finance.entitiy.AccountbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountbookService {

    @Autowired
    private AccountbookDao accountbookDao;

    public AccountbookEntity create(AccountbookEntity accountbookEntity) {
        return save(accountbookEntity);
    }

    public AccountbookEntity update(AccountbookEntity accountbookEntity) {
        return save(accountbookEntity);
    }

    public AccountbookEntity save(AccountbookEntity accountbookEntity){
        return accountbookDao.save(accountbookEntity);
    }

    public List<AccountbookEntity> get() {
        return accountbookDao.findAll();
    }

    public AccountbookEntity getOne(String id) {
        return accountbookDao.findById(id);
    }

    public void delete(AccountbookEntity accountbookEntity){
        accountbookDao.delete(accountbookEntity);

    }

}
