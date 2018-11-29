package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountFixedExpenditureEntity;
import cn.js.sandglass.finance.entitiy.FixedExpenditureEntity;
import cn.js.sandglass.finance.service.FixedExpenditureService;
import cn.js.sandglass.finance.valid.FixedExpenditureCreateValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FixedExpenditureController {

    @Autowired
    FixedExpenditureService fixedExpenditureService;

    /**
     *
     * @api {post} /fixed.expenditure 添加固定支出
     * @apiName fixed.expenditure.create
     * @apiGroup fixed
     * @apiVersion  1.0.0
     *
     * @apiParam  {string} account_id 账户id
     * @apiParam  {int} is_default_expenditure_type 是否默认支出类型
     * @apiParam  {string} expenditure_type 支出类型id(借出款)
     * @apiParam  {timestamp} time 时间
     * @apiParam  {float} amount 金额
     * @apiParam  {string} mark 备注
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     account_id : '1a098234b76d54c447b55a0',
     *     is_default_expenditure_type : 1,
     *     expenditure_type : '1a098234b76d54c447b55a0',
     *     time : 1529838734958
     *     amount : 1000
     * }
     *
     * @apiSuccess (201) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */

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

    /**
     *
     * @api {get} /fixed.expenditure 查询固定支出列表
     * @apiName fixed.expenditure.get
     * @apiGroup fixed
     * @apiVersion  1.0.0
     *
     * @apiParam  {string} account_id 账户id
     * @apiParam  {int} default_expenditure_type 是否默认支出类型
     * @apiParam  {string} expenditure_type 支出类型id
     * @apiParam  {timestamp} time 时间
     * @apiParam  {float} amount 金额
     * @apiParam  {string} mark 备注
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     account_id : '1a098234b76d54c447b55a0',
     *     default_expenditure_type : 1,
     *     expenditure_type : '1a098234b76d54c447b55a0',
     *     time : 1529838734958
     *     amount : 1000
     *     mark : ''
     * }
     *
     * @apiSuccess (201) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */


    @GetMapping(value = "fixed.expenditure")
    public Object get() {
        return fixedExpenditureService.get();
    }

    /**
     *
     * @api {get} /fixed.expenditure.one 查询固定支出详情
     * @apiName fixed.expenditure.one.get
     * @apiGroup fixed
     * @apiVersion  1.0.0
     *
     * @apiParam  {string} fixed.expenditure_id 支出id
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     expenditure_id : '1a098234b76d54c447b55a0',
     * }
     *
     * @apiSuccess (201) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */

    @GetMapping(value = "fixed.expenditure.one")
    public Object getOne(@RequestParam(value = "fixedExpenditureId") String id) {
        return fixedExpenditureService.getOne(id);
    }

}
