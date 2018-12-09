package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.FixedExpenditure;
import cn.js.sandglass.finance.service.AccountService;
import cn.js.sandglass.finance.service.FixedExpenditureService;
import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import cn.js.sandglass.finance.valid.FixedExpenditureCreateValid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "固定支出")
@RestController
public class FixedExpenditureController {

    @Autowired
    FixedExpenditureService fixedExpenditureService;

    @Autowired
    AccountService accountService;

    @PostMapping(value = "fixed.expenditure")
    public RetResult<FixedExpenditure> create(@Valid @RequestBody FixedExpenditureCreateValid fixedExpenditureCreateValid) {
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

        Account account=accountService.get(fixedExpenditureCreateValid.getAccountId());

        return RetResponse.ok(fixedExpenditureService.create(account, fixedExpenditure));
    }

    @GetMapping(value = "fixed.expenditure.list")
    public RetResult<List<FixedExpenditure>> list() {
        return RetResponse.ok(fixedExpenditureService.get());
    }

    @GetMapping(value = "fixed.expenditure")
    public RetResult<FixedExpenditure> getOne(@RequestParam(value = "fixedExpenditureId") String id) {
        return RetResponse.ok(fixedExpenditureService.getOne(id));
    }

}
