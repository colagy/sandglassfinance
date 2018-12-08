package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountFixedRevenue;
import cn.js.sandglass.finance.entitiy.FixedRevenue;
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
        FixedRevenue fixedRevenue = new FixedRevenue();
        fixedRevenue.setDefaultRevenueType(fixedRevenueCreateValid.getDefaultRevenueType());
        fixedRevenue.setRevenueTypeId(fixedRevenueCreateValid.getRevenueTypeId());
        fixedRevenue.setTimeUnit(fixedRevenueCreateValid.getTimeUnit());
        fixedRevenue.setStartTime(fixedRevenueCreateValid.getStartTime());
        fixedRevenue.setEndTime(fixedRevenueCreateValid.getEndTime());
        fixedRevenue.setAmount(fixedRevenueCreateValid.getAmount());
        fixedRevenue.setDay(fixedRevenueCreateValid.getDay());
        fixedRevenue.setMonth(fixedRevenueCreateValid.getMonth());
        fixedRevenue.setWeek(fixedRevenueCreateValid.getWeek());
        fixedRevenue.setMark(fixedRevenueCreateValid.getMark());

        AccountFixedRevenue accountFixedRevenue = new AccountFixedRevenue();
        accountFixedRevenue.setAccountId(fixedRevenueCreateValid.getAccountId());

        return fixedRevenueService.create(accountFixedRevenue, fixedRevenue);
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
