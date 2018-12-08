package cn.js.sandglass.finance.dao;

import cn.js.sandglass.finance.entitiy.Accountbook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountbookDao extends JpaRepository<Accountbook, Long> {

    Accountbook findById(String id);

}