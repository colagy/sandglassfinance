package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountFixedExpenditureDao;
import cn.js.sandglass.finance.dao.FixedExpenditureDao;
import cn.js.sandglass.finance.entitiy.AccountFixedExpenditure;
import cn.js.sandglass.finance.entitiy.FixedExpenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixedExpenditureService {

    @Autowired
    FixedExpenditureDao fixedExpenditureDao;

    @Autowired
    AccountFixedExpenditureDao accountFixedExpenditureDao;

    public FixedExpenditure create(AccountFixedExpenditure accountFixedExpenditure, FixedExpenditure fixedExpenditure){
        FixedExpenditure saveRes=save(fixedExpenditure);

        accountFixedExpenditure.setFixedExpenditureId(saveRes.getId());
        accountFixedExpenditureDao.save(accountFixedExpenditure);
        return saveRes;
    }

    public FixedExpenditure save(FixedExpenditure fixedExpenditure){
        return fixedExpenditureDao.save(fixedExpenditure);
    }

    public List<FixedExpenditure> get(){
        return find();
    }

    public List<FixedExpenditure> find(){
        return fixedExpenditureDao.findAll();
    }

    public Optional<FixedExpenditure> getOne(String id){
        return findById(id);
    }

    public Optional<FixedExpenditure> findById(String id){
        return fixedExpenditureDao.findById(id);
    }


}
