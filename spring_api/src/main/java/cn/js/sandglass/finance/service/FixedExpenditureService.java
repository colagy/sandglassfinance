package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.FixedExpenditureDao;
import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.FixedExpenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixedExpenditureService {

    @Autowired
    FixedExpenditureDao fixedExpenditureDao;

    public FixedExpenditure create(Account account, FixedExpenditure fixedExpenditure){
        FixedExpenditure saveRes=save(fixedExpenditure);
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

    public FixedExpenditure getOne(String id){
        return findById(id);
    }

    public FixedExpenditure findById(String id){
        return fixedExpenditureDao.findById(id);
    }

}
