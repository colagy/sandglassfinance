package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.UserDev;
import cn.js.sandglass.finance.entitiy.UserWechat;
import cn.js.sandglass.finance.service.UserWechatService;
import cn.js.sandglass.finance.util.WeappUtil;
import cn.js.sandglass.finance.service.LoginService;
import cn.js.sandglass.finance.service.RequestService;
import cn.js.sandglass.finance.service.UserService;
import cn.js.sandglass.finance.util.response.RetErr;
import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import cn.js.sandglass.finance.valid.LoginDevValid;
import cn.js.sandglass.finance.valid.LoginWeappSessionValid;
import cn.js.sandglass.finance.valid.LoginWeappValid;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "登录")
@RestController
public class LoginController {

    @Autowired
    RequestService requestService;

    @Autowired
    UserService userService;

    @Autowired
    UserWechatService userWechatService;

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login.weapp.session")
    public Object weappSession(@Valid @RequestBody LoginWeappSessionValid loginWeappSessionValid) {
        JSONObject res = loginService.getWeappOpenid(loginWeappSessionValid.getCode());
        // 获取openid
        if (res.containsKey("unionid")) {
            String unionid = res.getString("unionid");
            String openid = res.getString("openid");
            return loginService.weappLogin(unionid, openid);
        } else {
            return res;
        }

    }

    @PostMapping(value = "/login.weapp")
    public UserWechat weapp(@Valid @RequestBody LoginWeappValid loginWeappValid) {
        WeappUtil weappUtil = new WeappUtil();
        JSONObject jsonObject = weappUtil.getUserInfo(loginWeappValid.getEncryptedData(), loginWeappValid.getSessionKey(), loginWeappValid.getIv());
        System.out.println(jsonObject);
        String unionid = jsonObject.getString("unionId");
        String openid = jsonObject.getString("openId");
        return loginService.weappLogin(unionid, openid);
    }

    @PostMapping(value = "/login.dev")
    public RetResult<Object> dev(@Valid @RequestBody LoginDevValid loginDevValid) {
        UserDev userDev = new UserDev();
        userDev.setUsername(loginDevValid.getUsername());
        userDev.setPassword(loginDevValid.getPassword());
        try {
            return RetResponse.ok(loginService.devLogin(userDev));
        } catch (Exception e) {
            return RetResponse.err(RetErr.NOT_EXIST);
        }
    }

}
