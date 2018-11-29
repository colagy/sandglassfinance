package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.UserDao;
import cn.js.sandglass.finance.entitiy.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserEntity create(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    public List<UserEntity> getByUnionid(String unionid) {
        return userDao.findByUnionid(unionid);
    }

}
