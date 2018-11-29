package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountEntity;
import cn.js.sandglass.finance.entitiy.AccountbookAccountEntity;
import cn.js.sandglass.finance.service.AccountService;
import cn.js.sandglass.finance.valid.AccountCreateValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * @api {post} /account.create 添加账户
     * @apiName account.create
     * @apiGroup account
     * @apiVersion 1.0.0
     * @apiParam {string} type 账户类型
     * @apiParam {double} money 初始金额
     * @apiParamExample {json} Request-Example:
     * {
     * type : 0,
     * money : 100000,
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

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

    /**
     * @api {get} /account.get 查询账户列表
     * @apiName account.get
     * @apiGroup account
     * @apiVersion 1.0.0
     * @apiParam {string} accountbook_id 账本id
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
