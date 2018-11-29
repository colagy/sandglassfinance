package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.AccountbookEntity;
import cn.js.sandglass.finance.valid.*;
import cn.js.sandglass.finance.service.AccountbookService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountbookController {

    @Autowired
    private AccountbookService accountbookService;

    /**
     * @api {post} /accountbook.create 添加账本
     * @apiName accountbook.create
     * @apiGroup accountbook
     * @apiVersion 1.0.0
     * @apiParam {string} name 账本名称
     * @apiParamExample {json} Request-Example:
     * {
     * name : 'test name',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : "create ok"
     * }
     */

    @PostMapping(value = "/accountbook")
    public AccountbookEntity create(@Valid @RequestBody AccountbookCreateValid accountbookCreateValid) {
        var accountbookEntity=new AccountbookEntity();
        accountbookEntity.setName(accountbookCreateValid.getName());
        return  accountbookService.create(accountbookEntity);
    }

    /**
     * @api {get} /accountbook.get 查询账本
     * @apiName accountbook.get
     * @apiGroup accountbook
     * @apiVersion 1.0.0
     * @apiParam {string} user_id 用户id
     * @apiParamExample {json} Request-Example:
     * {
     * user_id : '1a3c98df0a87',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : "create ok"
     * }
     */

    @GetMapping(value = "/accountbook")
    public List<AccountbookEntity> get() {
        return accountbookService.get();
    }

    /**
     * @api {get} /accountbook.one.get 查询账本详情
     * @apiName accountbook.one.get
     * @apiGroup accountbook
     * @apiVersion 1.0.0
     * @apiParam {string} accountbook_id 账本id
     * @apiParamExample {json} Request-Example:
     * {
     * account_id : '1a3c98df0a87',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : "create ok"
     * }
     */

    @GetMapping(value = "/accountbook.one")
    public AccountbookEntity getOne(@RequestParam(value = "id",required = true) String id){
        return accountbookService.getOne(id);
    }

    /**
     * @api {put} /accountbook.update 修改账本
     * @apiName accountbook.update
     * @apiGroup accountbook
     * @apiVersion 1.0.0
     * @apiParam {string} accoutbook_id 账本id
     * @apiParamExample {json} Request-Example:
     * {
     * accountbook_id : '1a3c98df0a87',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : "create ok"
     * }
     */

    @PutMapping(value = "/accountbook")
    public AccountbookEntity update(@Valid @RequestBody AccountbookUpdateValid accountbookUpdateValid){
        AccountbookEntity accountbookEntity=new AccountbookEntity();
        accountbookEntity.setId(accountbookUpdateValid.getId());
        accountbookEntity.setName(accountbookUpdateValid.getName());
        accountbookEntity.setMark(accountbookUpdateValid.getMark());
        return accountbookService.update(accountbookEntity);
    }

    /**
     * @api {delete} /accountbook.delete 删除账本
     * @apiName accountbook.delete
     * @apiGroup accountbook
     * @apiVersion 1.0.0
     * @apiParam {string} accountbook_id 账本id
     * @apiParamExample {json} Request-Example:
     * {
     * accountbook_id : '1a3c98df0a87',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : "create ok"
     * }
     */

    @DeleteMapping(value = "/accountbook")
    public JSONObject delete(@Valid @RequestBody AccountbookDeleteValid accountbookDeleteValid){
        AccountbookEntity accountbookEntity=new AccountbookEntity();
        accountbookService.delete(accountbookEntity);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","delete ok");
        jsonObject.put("status",201);
        return jsonObject;
    }

}
