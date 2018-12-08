package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.UserWechatDao;
import cn.js.sandglass.finance.entitiy.UserWechat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWechatService {

    @Autowired
    UserWechatDao userWechatDao;

    public UserWechat create(UserWechat userWechat) {
        return userWechatDao.save(userWechat);
    }

    public UserWechat getByUnionid(String unionid) {
        return userWechatDao.findByUnionid(unionid);
    }


}

