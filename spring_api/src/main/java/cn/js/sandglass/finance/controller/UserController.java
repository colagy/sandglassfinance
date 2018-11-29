package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     *
     * @api {post} /user.create 添加账户
     * @apiName user.create
     * @apiGroup user
     * @apiVersion  1.0.0
     *
     * @apiParam  {string} openid 微信id
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     openid : 100000,
     * }
     *
     * @apiSuccess (201) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */

//    @PostMapping(value = "/user.create")
//    public UserEntity create(@RequestParam("i") String i){
//        return userDao.save();
//    }

    /**
     *
     * @api {get} /user.get 查询账户列表
     * @apiName user.get
     * @apiGroup user
     * @apiVersion  1.0.0
     *
     * @apiParam  {string} type 账户类型
     * @apiParam  {float} money 初始金额
     *
     * @apiParamExample  {json} Request-Example:
     * {
     *     type : 'wechat',
     *     money : 100000,
     * }
     *
     * @apiSuccess (201) {string} msg 添加成功
     *
     * @apiSuccessExample {type} Success-Response:
     * {
     *     msg : 'create ok'
     * }
     */

    @GetMapping(value = "/user.get")
    public String get(){
        return "hello world! get";
    }

}
