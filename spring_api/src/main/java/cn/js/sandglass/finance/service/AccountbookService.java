package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountbookDao;
import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.Accountbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountbookService {

    @Autowired
    private AccountbookDao accountbookDao;

    public Accountbook create(Accountbook accountbookEntity) {
        return save(accountbookEntity);
    }

    public Accountbook update(Accountbook accountbookEntity) {
        return save(accountbookEntity);
    }

    public Accountbook save(Accountbook accountbookEntity) {
        return accountbookDao.save(accountbookEntity);
    }

    public List<Accountbook> list() {
        return accountbookDao.findAll();
    }

    public Accountbook get(String id) {
        return accountbookDao.findById(id);
    }

    public void delete(Accountbook accountbookEntity) {
        accountbookDao.delete(accountbookEntity);

    }

}
