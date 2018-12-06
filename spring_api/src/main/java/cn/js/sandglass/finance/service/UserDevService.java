package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.UserDevDao;
import cn.js.sandglass.finance.entitiy.UserDevEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDevService {

    @Autowired
    UserDevDao userDevDao;

//    public UserDevEntity create(UserDevEntity userDevEntity) {
//        return devUserDao.save(userDevEntity);
//    }

    public UserDevEntity getByUsernameAndPassword(String username, String password) {
        return userDevDao.findByUsernameAndPassword(username,password);
    }


}

