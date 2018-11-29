package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountRevenueDao;
import cn.js.sandglass.finance.dao.RevenueDao;
import cn.js.sandglass.finance.entitiy.AccountRevenueEntity;
import cn.js.sandglass.finance.entitiy.RevenueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RevenueService {

    @Autowired
    private AccountRevenueDao accountRevenueDao;

    @Autowired
    private RevenueDao revenueDao;

    @Transactional
    public RevenueEntity create(AccountRevenueEntity accountRevenueEntity, RevenueEntity revenueEntity) {
        RevenueEntity saveRes = save(revenueEntity);

        accountRevenueEntity.setRevenueId(saveRes.getId());
        accountRevenueDao.save(accountRevenueEntity);

        return saveRes;
    }

    public RevenueEntity save(RevenueEntity revenueEntity) {
        return revenueDao.save(revenueEntity);
    }

    public List<RevenueEntity> get(String accountId, String startTime, String endTime){
        System.out.println(startTime);
        System.out.println(endTime);
        return revenueDao.getAllByTimeBetween(accountId,startTime,endTime);
    }

    public RevenueEntity getOne(String revenueId){
        return revenueDao.getById(revenueId);
    }

}
