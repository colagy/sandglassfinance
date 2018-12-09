package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.entitiy.UserDev;
import cn.js.sandglass.finance.entitiy.User;
import cn.js.sandglass.finance.entitiy.UserWechat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    @Autowired
    UserWechatService userWechatService;

    @Autowired
    UserDevService userDevService;

    @Autowired
    RequestService requestService;

    @Value("${user.salt}")
    private String SALT ;

    @Transactional
    public JSONObject getWeappOpenid(String code) {
        // 向微信服务器请求unionid openid
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", "wx3b0c244789896cce", "ddb4faa8414920750c6845fe9737b69e", code);
        HttpMethod method = HttpMethod.GET;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        JSONObject res = JSON.parseObject(requestService.client(url, method, params));
        JSONObject j = new JSONObject();
        // code不正确  返回错误
        if (res.containsKey("errcode")) {
            j.put("err", "code err");
            j.put("status", 4401);
            return j;
        }
        return res;
    }

    @Transactional
    public UserWechat weappLogin(String unionid, String openid) {
        // 判断用户是否已存在
        UserWechat wechatUserRes = userWechatService.getByUnionid(unionid);
        // 用户不存在  创建新用户
        if (wechatUserRes == null) {
            User user = new User();
            user.setType("wechat");
            User userRes = userService.create(user);
            UserWechat newWechatUser = new UserWechat();
            newWechatUser.setOpenid(openid);
            newWechatUser.setUnionid(unionid);
            newWechatUser.setUid(userRes.getId());
            UserWechat userWechatRes = userWechatService.create(newWechatUser);

            return userWechatRes;
        }
        // 用户存在  返回用户信息
        return wechatUserRes;
    }

    public Object devLogin(UserDev userDev) throws Exception {
        String username = userDev.getUsername();
        // 加密密码
        String pwSha1 = DigestUtils.sha1Hex(username + userDev.getPassword() + SALT);
        userDev.setPassword(pwSha1);
        // 查询用户
        UserDev userDevRes = userDevService.getByUsernameAndPassword(username, pwSha1);
        // 创建返回对象
        if (!StringUtils.isEmpty(userDevRes)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uid",userDevRes.getUid());
            return jsonObject;
        }else {
            throw new Exception("用户不存在");
        }
    }

}
