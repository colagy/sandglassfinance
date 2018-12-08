package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RevenueDao extends JpaRepository<Revenue, String> {

    @Query(value = "select * from revenue a left join account_revenue b on a.id=b.revenue_id where b.account_id=?1 and a.time between ?2 and ?3",nativeQuery = true)
    List<Revenue> getAllByTimeBetween(String accountId, String startTime, String endTime);

    Revenue getById(String id);

}
