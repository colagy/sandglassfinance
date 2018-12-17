package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.entitiy.Role;
import cn.js.sandglass.finance.entitiy.User;
import cn.js.sandglass.finance.entitiy.Wechat;
import cn.js.sandglass.finance.security.JwtAuthenticationManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LoginService {

    @Autowired
    UserService userService;

    @Autowired
    WechatService wechatService;

    @Autowired
    DevService devService;

    @Autowired
    RequestService requestService;

    @Value("${user.salt}")
    private String SALT;

    public Authentication login(String username, String password) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        AuthenticationManager jwtAuthenticationManager = new JwtAuthenticationManager();
        Authentication authentication = jwtAuthenticationManager.authenticate(authRequest); //调用loadUserByUsername
        SecurityContextHolder.getContext().setAuthentication(authentication);
//        HttpSession session = request.getSession();
//        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
        return authentication;
    }

    public Authentication localLogin(User user) {
        return login(user.getUsername(), user.getPassword());
    }

//    public Authentication wechatLogin(Wechat wechat) {
//
//    }

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
    public Wechat weappLogin(String unionid, String openid) {
        // 判断用户是否已存在
        Wechat wechatUserRes = wechatService.getByUnionid(unionid);
        // 用户不存在  创建新用户
        if (wechatUserRes == null) {
            Wechat wechat = new Wechat();
            wechat.setOpenid(openid);
            wechat.setUnionid(unionid);

            User user = new User();
            user.setUsername(unionid);
            user.setPassword(null);

            List<Role> roleList = new ArrayList<>();
            Role role = new Role();
            role.setName(Role.Name.WECHAT);
            roleList.add(role);
            user.setRoles(roleList);
            User userRes = userService.create(user);
            wechat.setUser(user);

            wechatUserRes = wechatService.create(wechat);
        }
        // 用户存在  返回用户信息
        return wechatUserRes;
    }

//    public Object devLogin(Dev dev) throws Exception {
//        String username = dev.getUsername();
//        // 加密密码
//        String pwSha1 = DigestUtils.sha1Hex(username + dev.getPassword() + SALT);
//        dev.setPassword(pwSha1);
//        // 查询用户
//        Dev devRes = userDevService.getByUsernameAndPassword(username, pwSha1);
//        // 创建返回对象
//        if (!StringUtils.isEmpty(devRes)) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("uid", devRes.getUid());
//            return jsonObject;
//        }else {
//            throw new Exception("用户不存在");
//        }
//    }

}
