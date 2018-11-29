package cn.js.sandglass.finance.security;

import cn.js.sandglass.finance.dao.UserDao;
import cn.js.sandglass.finance.entitiy.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String unionid) throws UsernameNotFoundException {
        // 这里是数据库里的用户类
        List<UserEntity> user = userDao.findByUnionid(unionid);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("没有该用户 '%s'.", unionid));
        } else {
            //这里返回上面继承了 UserDetails  接口的用户类,为了简单我们写个工厂类
            return UserFactory.create(user.get(0));
        }
    }
}