package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountFixedExpenditureDao;
import cn.js.sandglass.finance.dao.FixedExpenditureDao;
import cn.js.sandglass.finance.entitiy.AccountFixedExpenditureEntity;
import cn.js.sandglass.finance.entitiy.FixedExpenditureEntity;
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

    public FixedExpenditureEntity create(AccountFixedExpenditureEntity accountFixedExpenditureEntity, FixedExpenditureEntity fixedExpenditureEntity){
        FixedExpenditureEntity saveRes=save(fixedExpenditureEntity);

        accountFixedExpenditureEntity.setFixedExpenditureId(saveRes.getId());
        accountFixedExpenditureDao.save(accountFixedExpenditureEntity);
        return saveRes;
    }

    public FixedExpenditureEntity save(FixedExpenditureEntity fixedExpenditureEntity){
        return fixedExpenditureDao.save(fixedExpenditureEntity);
    }

    public List<FixedExpenditureEntity> get(){
        return find();
    }

    public List<FixedExpenditureEntity> find(){
        return fixedExpenditureDao.findAll();
    }

    public Optional<FixedExpenditureEntity> getOne(String id){
        return findById(id);
    }

    public Optional<FixedExpenditureEntity> findById(String id){
        return fixedExpenditureDao.findById(id);
    }


}
