package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.RevenueDao;
import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.Revenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RevenueService {

    @Autowired
    private RevenueDao revenueDao;

    @Transactional
    public Revenue create(Account account, Revenue revenue) {
        Revenue saveRes = save(revenue);

        return saveRes;
    }

    public Revenue save(Revenue revenue) {
        return revenueDao.save(revenue);
    }

    public List<Revenue> get(String accountId, String startTime, String endTime){
        System.out.println(startTime);
        System.out.println(endTime);
        return revenueDao.getAllByTimeBetween(accountId,startTime,endTime);
    }

    public Revenue getOne(String revenueId){
        return revenueDao.getById(revenueId);
    }

}
