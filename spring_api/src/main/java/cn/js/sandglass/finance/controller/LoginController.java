package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.User;
import cn.js.sandglass.finance.entitiy.Wechat;
import cn.js.sandglass.finance.service.*;
import cn.js.sandglass.finance.util.WeappUtil;
import cn.js.sandglass.finance.util.response.RetErr;
import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import cn.js.sandglass.finance.valid.LoginValid;
import cn.js.sandglass.finance.valid.LoginWeappSessionValid;
import cn.js.sandglass.finance.valid.LoginWeappValid;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(tags = "登录")
@RestController
public class LoginController {

    @Autowired
    RequestService requestService;

    @Autowired
    UserService userService;

    @Autowired
    WechatService wechatService;

    @Autowired
    LoginService loginService;


    @PostMapping(value = "/login.weapp.session")
    public Object weappSession(@Valid @RequestBody LoginWeappSessionValid loginWeappSessionValid) {
        JSONObject res = loginService.getWeappOpenid(loginWeappSessionValid.getCode());
        log.info(String.valueOf(res));
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
    public RetResult<Wechat> weapp(@Valid @RequestBody LoginWeappValid loginWeappValid) {
        WeappUtil weappUtil = new WeappUtil();
        try {
            JSONObject jsonObject = weappUtil.getUserInfo(loginWeappValid.getEncryptedData(), loginWeappValid.getSessionKey(), loginWeappValid.getIv());
            log.info(String.valueOf(jsonObject));
            String unionid = jsonObject.getString("unionId");
            String openid = jsonObject.getString("openId");
            return RetResponse.ok(loginService.weappLogin(unionid, openid));
        } catch (Exception e) {
            return RetResponse.errController(e.getMessage());
        }

    }
//
//    @PostMapping(value = "/login.dev")
//    public RetResult<Object> dev(@Valid @RequestBody LoginValid loginValid) {
//        Dev dev = new Dev();
//        dev.setUsername(loginValid.getUsername());
//        dev.setPassword(loginValid.getPassword());
//        try {
//            return RetResponse.ok(loginService.devLogin(dev));
//        } catch (Exception e) {
//            return RetResponse.err(RetErr.NOT_EXIST);
//        }
//    }

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")
    public RetResult<Authentication> login(@Valid @RequestBody LoginValid loginValid) {
        String usernameAndType = loginValid.getUsername();
        String password = loginValid.getPassword();
        Integer rememberMe = loginValid.getRememberMe();
        String type = usernameAndType.split(":")[0];
        String username = usernameAndType.split(":")[1];
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            if (type == "dev" || type == "admin") {
                return RetResponse.ok(loginService.localLogin(user));
            } else {
                return RetResponse.ok(loginService.localLogin(user));
            }
        } catch (AuthenticationException e) {
            RetErr retErr = RetErr.SERVICE_ERR;
            retErr.msg = "登录失败";
            return RetResponse.err(retErr);
        }

    }

}
