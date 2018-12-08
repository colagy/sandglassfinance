package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenditureDao extends JpaRepository<Expenditure,String> {

    @Query(value = "select * from expenditure a left join account_expenditure b on a.id=b.expenditure_id where b.account_id=?1 and a.time between ?2 and ?3",nativeQuery = true)
    List<Expenditure> getAllByTimeBetween(String accountId, String startTime, String endTime);

    Expenditure getById(String id);
}
