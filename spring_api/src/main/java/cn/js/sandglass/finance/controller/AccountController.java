package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.Account;
import cn.js.sandglass.finance.entitiy.AccountType;
import cn.js.sandglass.finance.entitiy.Accountbook;
import cn.js.sandglass.finance.service.AccountService;
import cn.js.sandglass.finance.service.AccountTypeService;
import cn.js.sandglass.finance.service.AccountbookService;
import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import cn.js.sandglass.finance.valid.AccountCreateValid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "账户")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountbookService accountbookService;

    @Autowired
    private AccountTypeService accountTypeService;

    @PostMapping(value = "/account")
    public RetResult<Account> create(@Valid @RequestBody AccountCreateValid accountCreateValid) {
        AccountType accountType=accountTypeService.get(accountCreateValid.getAccountTypeId());
        Accountbook accountbook=accountbookService.get(accountCreateValid.getAccountbookId());

        Account account = new Account();
        account.setBalance(accountCreateValid.getBalance());
        account.setMark(accountCreateValid.getMark());

        account.setAccountbook(accountbook);
        account.setAccountType(accountType);

        return RetResponse.ok(accountService.create(account));
    }

    @GetMapping(value = "/account.list")
    public RetResult<List<Account>> get(@RequestParam(value = "accountbook_id", required = true) String accountbookId) {
        Accountbook accountbook=accountbookService.get(accountbookId);
        return RetResponse.ok(accountbook.getAccounts());
    }

    /**
     *
     * @api {get} /account.one.get 查询账户详情
     * @apiName account.one.get
     * @apiGroup account
     * @apiVersion 1.0.0
     *
     * @apiParam  {string} account_id 账户id
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     account_id : '1a3c98df0a87',
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
     * @api {put} /account.update 修改账户
     * @apiName account.update
     * @apiGroup account
     * @apiVersion 1.0.0
     *
     * @apiParam  {string} account_id 账户id
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     account_id : '1a3c98df0a87',
     * }
     *
     * @apiSuccess (200) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */

    /**
     *
     * @api {delete} /account.delete 删除账户
     * @apiName account.delete
     * @apiGroup account
     * @apiVersion 1.0.0
     *
     * @apiParam  {string} account_id 账户id
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     account_id : '1a3c98df0a87',
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
