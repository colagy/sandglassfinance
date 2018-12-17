package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.Dev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevDao extends JpaRepository<Dev, Long> {

    Dev findById(String id);
    Dev findByUsername(String username);

}
