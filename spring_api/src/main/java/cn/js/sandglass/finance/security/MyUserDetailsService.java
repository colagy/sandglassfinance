package cn.js.sandglass.finance.security;

import cn.js.sandglass.finance.dao.UserDao;
import cn.js.sandglass.finance.dao.UserDevDao;
import cn.js.sandglass.finance.dao.UserWechatDao;
import cn.js.sandglass.finance.entitiy.User;
import cn.js.sandglass.finance.entitiy.UserDev;
import cn.js.sandglass.finance.entitiy.UserWechat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDevDao userDevDao;

    @Autowired
    private UserWechatDao userWechatDao;

    /**
     * 提供一种从用户名可以查到用户并返回的方法
     *
     * @param usernameData 帐号
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String usernameData) throws UsernameNotFoundException {
        // 这里是数据库里的用户类
        if (!usernameData.contains(":")) {
            throw new UsernameNotFoundException("username 格式不正确, 请使用 type:username 格式");
        }
        String type = usernameData.split(":")[0];
        String username = usernameData.split(":")[1];
        User user;
        switch (type) {
            case "dev":
                UserDev userDev = userDevDao.findByUsername(username);
                user = userDao.findById(userDev.getUid());
                break;
            case "wechat":
                UserWechat userWechat = userWechatDao.findByUnionid(username);
                user = userDao.findById(userWechat.getUid());
                break;
            default:
                throw new UsernameNotFoundException(String.format("用户类型不正确 type='%s'.", type));
        }

        if (user == null) {
            throw new UsernameNotFoundException(String.format("没有该用户 '%s'.", username));
        } else {
            //这里返回上面继承了 UserDetails  接口的用户类,为了简单我们写个工厂类
            return UserFactory.create(user);
        }
    }
}