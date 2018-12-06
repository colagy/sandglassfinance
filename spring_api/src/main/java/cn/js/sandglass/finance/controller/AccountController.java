package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountEntity;
import cn.js.sandglass.finance.entitiy.AccountbookAccountEntity;
import cn.js.sandglass.finance.service.AccountService;
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

    @PostMapping(value = "/account")
    public AccountEntity create(@Valid @RequestBody AccountCreateValid accountCreateValid) {
        var accountEntity = new AccountEntity();
        accountEntity.setAccountTypeId(accountCreateValid.getAccountTypeId());
        accountEntity.setBalance(accountCreateValid.getBalance());
        accountEntity.setMark(accountCreateValid.getMark());

        var accountbookAccountEntity = new AccountbookAccountEntity();
        accountbookAccountEntity.setAccountbookId(accountCreateValid.getAccountbookId());
        return accountService.create(accountbookAccountEntity, accountEntity);
    }

    @GetMapping(value = "/account")
    public List<AccountEntity> get(@RequestParam(value = "accountbook_id", required = true) String accountbookId) {
        return accountService.get(accountbookId);
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
