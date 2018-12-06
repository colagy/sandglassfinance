package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountFixedExpenditureEntity;
import cn.js.sandglass.finance.entitiy.FixedExpenditureEntity;
import cn.js.sandglass.finance.service.FixedExpenditureService;
import cn.js.sandglass.finance.valid.FixedExpenditureCreateValid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "固定支出")
@RestController
public class FixedExpenditureController {

    @Autowired
    FixedExpenditureService fixedExpenditureService;

    @PostMapping(value = "fixed.expenditure")
    public Object create(@Valid @RequestBody FixedExpenditureCreateValid fixedExpenditureCreateValid) {
        FixedExpenditureEntity fixedExpenditureEntity = new FixedExpenditureEntity();
        fixedExpenditureEntity.setDefaultExpenditureType(fixedExpenditureCreateValid.getDefaultExpenditureType());
        fixedExpenditureEntity.setExpenditureTypeId(fixedExpenditureCreateValid.getExpenditureTypeId());
        fixedExpenditureEntity.setTimeUnit(fixedExpenditureCreateValid.getTimeUnit());
        fixedExpenditureEntity.setStartTime(fixedExpenditureCreateValid.getStartTime());
        fixedExpenditureEntity.setEndTime(fixedExpenditureCreateValid.getEndTime());
        fixedExpenditureEntity.setAmount(fixedExpenditureCreateValid.getAmount());
        fixedExpenditureEntity.setDay(fixedExpenditureCreateValid.getDay());
        fixedExpenditureEntity.setMonth(fixedExpenditureCreateValid.getMonth());
        fixedExpenditureEntity.setWeek(fixedExpenditureCreateValid.getWeek());
        fixedExpenditureEntity.setMark(fixedExpenditureCreateValid.getMark());

        AccountFixedExpenditureEntity accountFixedExpenditureEntity = new AccountFixedExpenditureEntity();
        accountFixedExpenditureEntity.setAccountId(fixedExpenditureCreateValid.getAccountId());

        return fixedExpenditureService.create(accountFixedExpenditureEntity, fixedExpenditureEntity);
    }

    @GetMapping(value = "fixed.expenditure")
    public Object get() {
        return fixedExpenditureService.get();
    }

    @GetMapping(value = "fixed.expenditure.one")
    public Object getOne(@RequestParam(value = "fixedExpenditureId") String id) {
        return fixedExpenditureService.getOne(id);
    }

}
