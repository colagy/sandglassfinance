package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.entitiy.UserEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    @Autowired
    RequestService requestService;

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
    public UserEntity weappLogin(String unionid, String openid) {
        // 判断用户是否已存在
        List<UserEntity> userRes = userService.getByUnionid(unionid);
        // 用户不存在  创建新用户
        if (userRes == null || userRes.size() == 0) {
            UserEntity newUser = new UserEntity();
            newUser.setOpenid(openid);
            newUser.setUnionid(unionid);
            newUser.setType(0);
            UserEntity userCreateRes = userService.create(newUser);
            return userCreateRes;
        }
        // 用户存在  返回用户信息
        return userRes.get(0);
    }

}
