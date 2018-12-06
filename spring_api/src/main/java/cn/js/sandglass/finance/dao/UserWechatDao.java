package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.UserWechatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserWechatDao extends JpaRepository<UserWechatEntity, Long> {

    public List<UserWechatEntity> findByUnionid(String unionid);

}
