package cn.js.sandglass.finance.service;

        import cn.js.sandglass.finance.dao.ExpenditureTypeDao;
        import cn.js.sandglass.finance.entitiy.ExpenditureTypeEntity;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class ExpenditureTypeService {

    @Autowired
    ExpenditureTypeDao expenditureTypeDao;

    public List<ExpenditureTypeEntity> get(){
        return expenditureTypeDao.findAll();
    }

}
