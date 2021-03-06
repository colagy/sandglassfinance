package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.RevenueTypeDao;
import cn.js.sandglass.finance.entitiy.RevenueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueTypeService {

    @Autowired
    private RevenueTypeDao revenueTypeDao;

    public List<RevenueType> get(){
        return revenueTypeDao.findAll();
    }

}
