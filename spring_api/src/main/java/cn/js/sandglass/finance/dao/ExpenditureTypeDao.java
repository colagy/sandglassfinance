package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.ExpenditureTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenditureTypeDao extends JpaRepository<ExpenditureTypeEntity, Long> {
}
