package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountExpenditureDao;
import cn.js.sandglass.finance.dao.ExpenditureDao;
import cn.js.sandglass.finance.entitiy.AccountExpenditureEntity;
import cn.js.sandglass.finance.entitiy.ExpenditureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpenditureService {

    @Autowired
    ExpenditureDao expenditureDao;

    @Autowired
    AccountExpenditureDao accountExpenditureDao;

    @Transactional
    public ExpenditureEntity create(AccountExpenditureEntity accountExpenditureEntity, ExpenditureEntity expenditureEntity){
        ExpenditureEntity saveRes= save(expenditureEntity);

        accountExpenditureEntity.setExpenditureId(saveRes.getId());
        accountExpenditureDao.save(accountExpenditureEntity);
        return saveRes;
    }

    public ExpenditureEntity save(ExpenditureEntity expenditureEntity){
        return expenditureDao.save(expenditureEntity);
    }

    public List<ExpenditureEntity> get(String accountId, String startTime, String endTime){
        return expenditureDao.getAllByTimeBetween(accountId,startTime,endTime);
    }

    public ExpenditureEntity getOne(String expenditureId){
        return expenditureDao.getById(expenditureId);
    }

}
