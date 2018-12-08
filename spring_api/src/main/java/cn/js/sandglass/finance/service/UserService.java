package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.UserDao;
import cn.js.sandglass.finance.entitiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User create(User user) {
        return userDao.save(user);
    }

    public User getById(String id) {
        return userDao.findById(id);
    }

}
