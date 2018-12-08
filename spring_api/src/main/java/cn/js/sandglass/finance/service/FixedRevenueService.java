package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.AccountFixedRevenueDao;
import cn.js.sandglass.finance.dao.FixedRevenueDao;
import cn.js.sandglass.finance.entitiy.AccountFixedRevenue;
import cn.js.sandglass.finance.entitiy.FixedRevenue;
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

    public FixedRevenue create(AccountFixedRevenue accountFixedRevenue, FixedRevenue fixedRevenue){
        FixedRevenue saveRes=save(fixedRevenue);

        accountFixedRevenue.setFixedRevenueId(saveRes.getId());
        accountFixedRevenueDao.save(accountFixedRevenue);
        return saveRes;
    }

    public FixedRevenue save(FixedRevenue fixedRevenue){
        return fixedRevenueDao.save(fixedRevenue);
    }

    public List<FixedRevenue> get(){
        return find();
    }

    public List<FixedRevenue> find(){
        return fixedRevenueDao.findAll();
    }

    public Optional<FixedRevenue> getOne(String id){
        return findById(id);
    }

    public Optional<FixedRevenue> findById(String id){
        return fixedRevenueDao.findById(id);
    }


}
