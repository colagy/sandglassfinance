package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.DevDao;
import cn.js.sandglass.finance.entitiy.Dev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevService {

    @Autowired
    DevDao devDao;

    public Dev save(Dev dev) {
        return devDao.save(dev);
    }

    public Dev update(Dev dev) {
        return save(dev);
    }

    public Dev getById(String id) {
        return devDao.findById(id);
    }

    public Dev getByUsername(String username) {
        return devDao.findByUsername(username);
    }

}

