package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountFixedRevenueEntity;
import cn.js.sandglass.finance.entitiy.FixedRevenueEntity;
import cn.js.sandglass.finance.service.FixedRevenueService;
import cn.js.sandglass.finance.valid.FixedRevenueCreateValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FixedRevenueController {

    @Autowired
    FixedRevenueService fixedRevenueService;

    /**
     * @api {post} /fixed.revenue 添加固定收入
     * @apiName fixed.revenue.create
     * @apiGroup fixed
     * @apiVersion 1.0.0
     * @apiParam {string} account_id 账户id
     * @apiParam {int} is_default_revenue_type 是否默认收入类型
     * @apiParam {string} revenue_type_id 收入id
     * @apiParam {int} amount 金额
     * @apiParam {date} time 时间
     * @apiParam {string} mark 备注
     * @apiParamExample {json} Request-Example:
     * {
     * type : 'wechat',
     * money : 100000,
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

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

    /**
     * @api {get} /fixed.revenue 查询固定收入列表
     * @apiName fixed.revenue.get
     * @apiGroup fixed
     * @apiVersion 1.0.0
     * @apiParam {string} accountId 账户id
     * @apiParam {string} startTime 开始时间
     * @apiParam {string} endTime 结束时间
     * @apiParamExample {json} Request-Example:
     * {
     * account_id : '1a438dbefa0cc67bd34ea9',
     * start_time : '1520384735873',
     * end_time : '1520395846984',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

    @GetMapping(value = "fixed.revenue")
    public Object get() {
        return fixedRevenueService.get();
    }

    /**
     * @api {get} /fixed.revenue.one 查询固定收入详情
     * @apiName fixed.revenue.one.get
     * @apiGroup fixed
     * @apiVersion 1.0.0
     * @apiParam {string} fixed_revenue_id 收入id
     * @apiParam {string} start_time 开始时间
     * @apiParam {string} end_time 结束时间
     * @apiParamExample {json} Request-Example:
     * {
     * account_id : '1a438dbefa0cc67bd34ea9',
     * start_time : '1520384735873',
     * end_time : '1520395846984',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

    @GetMapping(value = "fixed.revenue.one")
    public Object getOne(@RequestParam(value = "fixedRevenueId") String id) {
        return fixedRevenueService.getOne(id);
    }

}
