package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountFixedRevenueEntity;
import cn.js.sandglass.finance.entitiy.FixedRevenueEntity;
import cn.js.sandglass.finance.service.FixedRevenueService;
import cn.js.sandglass.finance.valid.FixedRevenueCreateValid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "固定收入")
@RestController
public class FixedRevenueController {

    @Autowired
    FixedRevenueService fixedRevenueService;

    @PostMapping(value = "fixed.revenue")
    public Object create(@Valid @RequestBody FixedRevenueCreateValid fixedRevenueCreateValid) {
        FixedRevenueEntity fixedRevenueEntity = new FixedRevenueEntity();
        fixedRevenueEntity.setDefaultRevenueType(fixedRevenueCreateValid.getDefaultRevenueType());
        fixedRevenueEntity.setRevenueTypeId(fixedRevenueCreateValid.getRevenueTypeId());
        fixedRevenueEntity.setTimeUnit(fixedRevenueCreateValid.getTimeUnit());
        fixedRevenueEntity.setStartTime(fixedRevenueCreateValid.getStartTime());
        fixedRevenueEntity.setEndTime(fixedRevenueCreateValid.getEndTime());
        fixedRevenueEntity.setAmount(fixedRevenueCreateValid.getAmount());
        fixedRevenueEntity.setDay(fixedRevenueCreateValid.getDay());
        fixedRevenueEntity.setMonth(fixedRevenueCreateValid.getMonth());
        fixedRevenueEntity.setWeek(fixedRevenueCreateValid.getWeek());
        fixedRevenueEntity.setMark(fixedRevenueCreateValid.getMark());

        AccountFixedRevenueEntity accountFixedRevenueEntity = new AccountFixedRevenueEntity();
        accountFixedRevenueEntity.setAccountId(fixedRevenueCreateValid.getAccountId());

        return fixedRevenueService.create(accountFixedRevenueEntity, fixedRevenueEntity);
    }

    @GetMapping(value = "fixed.revenue")
    public Object get() {
        return fixedRevenueService.get();
    }

    @GetMapping(value = "fixed.revenue.one")
    public Object getOne(@RequestParam(value = "fixedRevenueId") String id) {
        return fixedRevenueService.getOne(id);
    }

}
