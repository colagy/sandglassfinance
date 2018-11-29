package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountFixedRevenueDao;
import cn.js.sandglass.finance.dao.FixedRevenueDao;
import cn.js.sandglass.finance.entitiy.AccountFixedRevenueEntity;
import cn.js.sandglass.finance.entitiy.FixedRevenueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixedRevenueService {

    @Autowired
    FixedRevenueDao fixedRevenueDao;

    @Autowired
    AccountFixedRevenueDao accountFixedRevenueDao;

    public FixedRevenueEntity create(AccountFixedRevenueEntity accountFixedRevenueEntity, FixedRevenueEntity fixedRevenueEntity){
        FixedRevenueEntity saveRes=save(fixedRevenueEntity);

        accountFixedRevenueEntity.setFixedRevenueId(saveRes.getId());
        accountFixedRevenueDao.save(accountFixedRevenueEntity);
        return saveRes;
    }

    public FixedRevenueEntity save(FixedRevenueEntity fixedRevenueEntity){
        return fixedRevenueDao.save(fixedRevenueEntity);
    }

    public List<FixedRevenueEntity> get(){
        return find();
    }

    public List<FixedRevenueEntity> find(){
        return fixedRevenueDao.findAll();
    }

    public Optional<FixedRevenueEntity> getOne(String id){
        return findById(id);
    }

    public Optional<FixedRevenueEntity> findById(String id){
        return fixedRevenueDao.findById(id);
    }


}
