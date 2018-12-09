package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.service.AccountService;
import cn.js.sandglass.finance.util.TimeUtil;
import cn.js.sandglass.finance.entitiy.Expenditure;
import cn.js.sandglass.finance.service.ExpenditureService;
import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import cn.js.sandglass.finance.valid.ExpenditureCreateValid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "支出")
@RestController
public class ExpenditureController {

    @Autowired
    ExpenditureService expenditureService;

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/expenditure")
    public RetResult<Expenditure> create(@Valid @RequestBody ExpenditureCreateValid expenditureCreateValid) {
        Expenditure expenditure = new Expenditure();
        expenditure.setDefaultExpenditureType(expenditureCreateValid.getDefaultExpenditureType());
        expenditure.setExpenditureTypeId(expenditureCreateValid.getExpenditureTypeId());
        expenditure.setAmount(expenditureCreateValid.getAmount());
        expenditure.setTime(expenditureCreateValid.getTime());
        expenditure.setMark(expenditureCreateValid.getMark());

        Account account=accountService.get(expenditureCreateValid.getAccountId());

        return RetResponse.ok(expenditureService.create(account, expenditure));
    }

    @GetMapping(value = "/expenditure.list")
    public RetResult<List<Expenditure>> list(
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "startTime") Long startTime,
            @RequestParam(value = "endTime") Long endTime) {
        return RetResponse.ok(expenditureService.get(accountId, TimeUtil.timestampLongToDateStr(startTime), TimeUtil.timestampLongToDateStr(endTime)));
    }

    @GetMapping(value = "expenditure.one")
    public RetResult<Expenditure> getOne(@RequestParam(value = "expenditureId") String expenditureId) {
        return RetResponse.ok(expenditureService.getOne(expenditureId));
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
