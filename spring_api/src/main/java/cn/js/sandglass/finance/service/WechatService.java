package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.WechatDao;
import cn.js.sandglass.finance.entitiy.Wechat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatService {

    @Autowired
    WechatDao wechatDao;

    public Wechat create(Wechat wechat) {
        return wechatDao.save(wechat);
    }

    public Wechat getByUnionid(String unionid) {
        return wechatDao.findByUnionid(unionid);
    }

    public Wechat getById(String id) {
        return wechatDao.findById(id);
    }

}

