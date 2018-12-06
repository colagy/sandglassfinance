package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.util.TimeUtil;
import cn.js.sandglass.finance.entitiy.AccountRevenueEntity;
import cn.js.sandglass.finance.entitiy.RevenueEntity;
import cn.js.sandglass.finance.service.RevenueService;
import cn.js.sandglass.finance.service.RevenueTypeService;
import cn.js.sandglass.finance.valid.RevenueCreateValid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "收入")
@RestController
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @Autowired
    private RevenueTypeService revenueTypeService;

    /**
     * @api {post} /revenue 添加收入
     * @apiName revenue.create
     * @apiGroup revenue
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

    @PostMapping(value = "/revenue")
    public Object create(@Valid @RequestBody RevenueCreateValid revenueCreateValid) {
        RevenueEntity revenueEntity = new RevenueEntity();
        revenueEntity.setAmount(revenueCreateValid.getAmount());
        revenueEntity.setDefaultRevenueType(revenueCreateValid.getDefaultRevenueType());
        revenueEntity.setRevenueTypeId(revenueCreateValid.getRevenueTypeId());
        revenueEntity.setTime(revenueCreateValid.getTime());
        revenueEntity.setMark(revenueCreateValid.getMark());

        AccountRevenueEntity accountRevenueEntity = new AccountRevenueEntity();
        accountRevenueEntity.setAccountId(revenueCreateValid.getAccountId());

        return revenueService.create(accountRevenueEntity, revenueEntity);
    }

    /**
     * @api {get} /revenue 查询收入列表
     * @apiName revenue.get
     * @apiGroup revenue
     * @apiVersion 1.0.0
     * @apiParam {string} accountId 账户id
     * @apiParam {string} startTime 开始时间
     * @apiParam {string} endTime 结束时间
     * @apiParamExample {json} Request-Example:
     * {
     * accountbook_id : '1a438dbefa0cc67bd34ea9',
     * start_time : '1520384735873',
     * end_time : '1520395846984',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

    @GetMapping(value = "/revenue")
    public Object get(
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime) {

        return revenueService.get(accountId, TimeUtil.timestampStrToDateStr(startTime), TimeUtil.timestampStrToDateStr(endTime));
    }

    /**
     * @api {get} /revenue.one 查询收入详情
     * @apiName revenue.one.get
     * @apiGroup revenue
     * @apiVersion 1.0.0
     * @apiParam {string} revenue_id 收入id
     * @apiParam {string} start_time 开始时间
     * @apiParam {string} end_time 结束时间
     * @apiParamExample {json} Request-Example:
     * {
     * accountbook_id : '1a438dbefa0cc67bd34ea9',
     * start_time : '1520384735873',
     * end_time : '1520395846984',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

    @GetMapping(value = "/revenue.one")
    public Object getOne(@RequestParam(value = "revenueId") String revenueId) {
        return revenueService.getOne(revenueId);
    }

    /**
     *
     * @api {put} /revenue 修改收入
     * @apiName revenue.update
     * @apiGroup revenue
     * @apiVersion 1.0.0
     *
     * @apiParam  {string} revenue_id 收入id
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     revenue_id : '1a098234b76d54c447b55a0',
     * }
     *
     * @apiSuccess (201) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */

    /**
     *
     * @api {delete} /revenue 删除收入
     * @apiName revenue.delete
     * @apiGroup revenue
     * @apiVersion 1.0.0
     *
     * @apiParam  {string} revenue_id 收入id
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     revenue_id : '1a098234b76d54c447b55a0',
     * }
     *
     * @apiSuccess (201) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */

    /**
     * @api {get} /revenue.type 查询收入类型列表
     * @apiName revenue.type.get
     * @apiGroup revenue
     * @apiVersion 1.0.0
     * @apiParamExample {json} Request-Example:
     * {
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

    @GetMapping(value = "/revenue.type")
    public Object getRevenueType() {
        return revenueTypeService.get();
    }

}
