package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.FixedExpenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedExpenditureDao extends JpaRepository<FixedExpenditure,Long> {

    FixedExpenditure findById(String id);

}
