package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserWechat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserWechatDao extends JpaRepository<UserWechat, Long> {

    public UserWechat findByUnionid(String unionid);

}
