package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.ExpenditureDao;
import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.Expenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpenditureService {

    @Autowired
    ExpenditureDao expenditureDao;

    @Transactional
    public Expenditure create(Account account, Expenditure expenditure){

        Expenditure saveRes= save(expenditure);
        return saveRes;
    }

    public Expenditure save(Expenditure expenditure){
        return expenditureDao.save(expenditure);
    }

    public List<Expenditure> get(String accountId, String startTime, String endTime){
        return expenditureDao.getAllByTimeBetween(accountId,startTime,endTime);
    }

    public Expenditure getOne(String expenditureId){
        return expenditureDao.getById(expenditureId);
    }

}
