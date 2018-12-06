package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.UserWechatDao;
import cn.js.sandglass.finance.entitiy.UserWechatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWechatService {

    @Autowired
    UserWechatDao userWechatDao;

    public UserWechatEntity create(UserWechatEntity userWechatEntity) {
        return userWechatDao.save(userWechatEntity);
    }

    public List<UserWechatEntity> getByUnionid(String unionid) {
        return userWechatDao.findByUnionid(unionid);
    }


}

