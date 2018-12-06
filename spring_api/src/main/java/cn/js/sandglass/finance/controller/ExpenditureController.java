package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.util.TimeUtil;
import cn.js.sandglass.finance.entitiy.AccountExpenditureEntity;
import cn.js.sandglass.finance.entitiy.ExpenditureEntity;
import cn.js.sandglass.finance.service.ExpenditureService;
import cn.js.sandglass.finance.valid.ExpenditureCreateValid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "支出")
@RestController
public class ExpenditureController {

    @Autowired
    ExpenditureService expenditureService;

    @PostMapping(value = "/expenditure")
    public Object create(@Valid @RequestBody ExpenditureCreateValid expenditureCreateValid) {
        ExpenditureEntity expenditureEntity = new ExpenditureEntity();
        expenditureEntity.setDefaultExpenditureType(expenditureCreateValid.getDefaultExpenditureType());
        expenditureEntity.setExpenditureTypeId(expenditureCreateValid.getExpenditureTypeId());
        expenditureEntity.setAmount(expenditureCreateValid.getAmount());
        expenditureEntity.setTime(expenditureCreateValid.getTime());
        expenditureEntity.setMark(expenditureCreateValid.getMark());

        AccountExpenditureEntity accountExpenditureEntity = new AccountExpenditureEntity();
        accountExpenditureEntity.setAccountId(expenditureCreateValid.getAccountId());

        return expenditureService.create(accountExpenditureEntity, expenditureEntity);
    }

    @GetMapping(value = "/expenditure")
    public Object get(
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "startTime") Long startTime,
            @RequestParam(value = "endTime") Long endTime) {
        return expenditureService.get(accountId, TimeUtil.timestampLongToDateStr(startTime), TimeUtil.timestampLongToDateStr(endTime));
    }

    @GetMapping(value = "expenditure.one")
    public Object getOne(@RequestParam(value = "expenditureId") String expenditureId) {
        return expenditureService.getOne(expenditureId);
    }

    /**
     *
     * @api {put} /expenditure 修改支出
     * @apiName expenditure.update
     * @apiGroup expenditure
     * @apiVersion 1.0.0
     *
     * @apiParam  {string} expenditure_id 支出id
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

    /**
     *
     * @api {delete} /expenditure 删除支出
     * @apiName expenditure.delete
     * @apiGroup expenditure
     * @apiVersion 1.0.0
     *
     * @apiParam  {string} expenditure_id 支出id
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

}
