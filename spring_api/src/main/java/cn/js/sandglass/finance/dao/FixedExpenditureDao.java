package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.FixedExpenditureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedExpenditureDao extends JpaRepository<FixedExpenditureEntity,String> {
}
