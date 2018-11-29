package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.util.WeappUtil;
import cn.js.sandglass.finance.entitiy.UserEntity;
import cn.js.sandglass.finance.service.LoginService;
import cn.js.sandglass.finance.service.RequestService;
import cn.js.sandglass.finance.service.UserService;
import cn.js.sandglass.finance.valid.LoginWeappSessionValid;
import cn.js.sandglass.finance.valid.LoginWeappValid;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    RequestService requestService;

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    /**
     * @api {get} /login.weapp.session 查询会话密钥
     * @apiName login.weapp.session.get
     * @apiGroup login
     * @apiVersion 1.0.0
     * @apiParam {string} code 微信小程序code
     * @apiParamExample {json} Request-Example:
     * {
     * code : '1c3087a7675b64dc760',
     * }
     * @apiSuccess (201) {string} openid 微信小程序id
     * @apiSuccess (201) {string} session_key 会话密钥
     * @apiSuccess (201) {string} unionid 微信开放平台id
     * @apiSuccessExample {type} Success-Response:
     * {
     * openid : 'oJ2764vEXcyeWJNK2jdxBAYDhEb0',
     * session_key : 'tLN1SM/70tYraX6MRfiu3g==',
     * unoinid : 'oJ7223vEXcyeWJNK5jdxBAYDhEb0',
     * }
     */

    @PostMapping(value = "/login.weapp.session")
    public Object weappSession(@Valid @RequestBody LoginWeappSessionValid loginWeappSessionValid){
        JSONObject res= loginService.getWeappOpenid(loginWeappSessionValid.getCode());
        // 获取openid
        if(res.containsKey("unionid")){
            String unionid = res.getString("unionid");
            String openid = res.getString("openid");
            return loginService.weappLogin(unionid,openid);
        }else{
            return res;
        }

    }

    /**
     * @api {post} /login.weapp 小程序登录
     * @apiName login.weapp
     * @apiGroup login
     * @apiVersion 1.0.0
     * @apiParam {string} unionid 微信开放平台id
     * @apiParamExample {json} Request-Example:
     * {
     * unionid : 'oJ7223vEXcyeWJNK5jdxBAYDhEb0',
     * }
     * @apiSuccess (201) {string} msg 添加成功
     * @apiSuccessExample {type} Success-Response:
     * {
     * msg : 'create ok'
     * }
     */

    @PostMapping(value = "/login.weapp")
    public UserEntity weapp(@Valid @RequestBody LoginWeappValid loginWeappValid) {
        WeappUtil weappUtil=new WeappUtil();
        JSONObject jsonObject= weappUtil.getUserInfo(loginWeappValid.getEncryptedData(),loginWeappValid.getSessionKey(),loginWeappValid.getIv());
        System.out.println(jsonObject);
        String unionid=jsonObject.getString("unionId");
        String openid=jsonObject.getString("openId");
        return loginService.weappLogin(unionid,openid);
    }

}
