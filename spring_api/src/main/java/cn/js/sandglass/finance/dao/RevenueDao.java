package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.RevenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RevenueDao extends JpaRepository<RevenueEntity, String> {

    @Query(value = "select * from revenue a left join account_revenue b on a.id=b.revenue_id where b.account_id=?1 and a.time between ?2 and ?3",nativeQuery = true)
    List<RevenueEntity> getAllByTimeBetween(String accountId, String startTime, String endTime);

    RevenueEntity getById(String id);

}
