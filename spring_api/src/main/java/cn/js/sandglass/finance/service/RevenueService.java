package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountRevenueDao;
import cn.js.sandglass.finance.dao.RevenueDao;
import cn.js.sandglass.finance.entitiy.AccountRevenue;
import cn.js.sandglass.finance.entitiy.Revenue;
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
    public Revenue create(AccountRevenue accountRevenue, Revenue revenue) {
        Revenue saveRes = save(revenue);

        accountRevenue.setRevenueId(saveRes.getId());
        accountRevenueDao.save(accountRevenue);

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
