package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.Wechat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WechatDao extends JpaRepository<Wechat, Long> {

    Wechat findByUnionid(String unionid);

    Wechat findById(String id);

}
