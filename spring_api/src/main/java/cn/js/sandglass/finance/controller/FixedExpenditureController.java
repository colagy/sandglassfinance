package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountFixedExpenditure;
import cn.js.sandglass.finance.entitiy.FixedExpenditure;
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
        FixedExpenditure fixedExpenditure = new FixedExpenditure();
        fixedExpenditure.setDefaultExpenditureType(fixedExpenditureCreateValid.getDefaultExpenditureType());
        fixedExpenditure.setExpenditureTypeId(fixedExpenditureCreateValid.getExpenditureTypeId());
        fixedExpenditure.setTimeUnit(fixedExpenditureCreateValid.getTimeUnit());
        fixedExpenditure.setStartTime(fixedExpenditureCreateValid.getStartTime());
        fixedExpenditure.setEndTime(fixedExpenditureCreateValid.getEndTime());
        fixedExpenditure.setAmount(fixedExpenditureCreateValid.getAmount());
        fixedExpenditure.setDay(fixedExpenditureCreateValid.getDay());
        fixedExpenditure.setMonth(fixedExpenditureCreateValid.getMonth());
        fixedExpenditure.setWeek(fixedExpenditureCreateValid.getWeek());
        fixedExpenditure.setMark(fixedExpenditureCreateValid.getMark());

        AccountFixedExpenditure accountFixedExpenditure = new AccountFixedExpenditure();
        accountFixedExpenditure.setAccountId(fixedExpenditureCreateValid.getAccountId());

        return fixedExpenditureService.create(accountFixedExpenditure, fixedExpenditure);
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
