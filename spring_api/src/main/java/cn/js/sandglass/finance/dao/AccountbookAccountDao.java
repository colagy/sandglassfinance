package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.AccountbookAccount;
import cn.js.sandglass.finance.entitiy.Accountbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountbookAccountDao extends JpaRepository<AccountbookAccount, Long> {

    @Query(value = "select * from accountbook_account a,accountbook b where a.account_id=?1 and a.accountbook_id=b.id",nativeQuery = true)
    Accountbook getAccountbookByAccountId(String id);

    /**
     * 1.1、账本关联查询
     * @param id
     * @return
     */
    @Query(value = "select * from accountbook_account where accountbook_id_id=?1", nativeQuery = true)
    List<AccountbookAccount> getByAccountbookId(String id);

    /**
     * 1.2、账户关联查询
     * @param id
     * @return
     */
    @Query(value = "select * from accountbook_account where account_id=?1", nativeQuery = true)
    List<AccountbookAccount> getByAccountId(String id);

    /**
     * 2.1、通过账本 id 删除账本账户关系
     * ① 在 dao 层中加上 @Modifying
     * ② 注意添加 @Transactional，否则 TransactionRequiredException
     * ③ @Transactional 建议还是在 Service 层中加上，不要在 Controller 层中
     */
    @Modifying
    @Query(value="delete from accountbook_account where accountbook_id=?1",nativeQuery=true)
    void deleteByAccountbookId(String id);

    /**
     * 2.2、通过学生 id 删除师生关系
     * ① 在 dao 层中加上 @Modifying，否则 SQLException
     * ② 注意添加 @Transactional，否则 TransactionRequiredException
     * ③ @Transactional 建议还是在 Service 层中加上，不要在 Controller 层中
     */
    @Modifying
    @Query(value="delete from accountbook_account where account_id=?1",nativeQuery=true)
    void deleteByAccountId(String id);

}
