package cn.js.sandglass.finance.service;

import cn.js.sandglass.finance.dao.RoleDao;
import cn.js.sandglass.finance.dao.UserDao;
import cn.js.sandglass.finance.entitiy.User;
import cn.js.sandglass.finance.security.MyTokenUtil;
import cn.js.sandglass.finance.security.MyUserDetailsService;
import cn.js.sandglass.finance.util.exception.MyException;
import cn.js.sandglass.finance.util.response.RetErr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
@SuppressWarnings("all")
public class AuthService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private AuthenticationManager authenticationManager;
    private MyUserDetailsService myUserDetailsService;
    private MyTokenUtil myTokenUtil;
    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public AuthService(
            AuthenticationManager authenticationManager,
            MyUserDetailsService myUserDetailsService,
            MyTokenUtil myTokenUtil,
            UserDao userDao,
            RoleDao roleDao) {
        this.authenticationManager = authenticationManager;
        this.myUserDetailsService = myUserDetailsService;
        this.myTokenUtil = myTokenUtil;
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    public String login(String username, String password) throws MyException {

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            final Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
            return myTokenUtil.generateToken(userDetails);
        } catch (BadCredentialsException e) {
            logger.debug(e.getMessage());
            RetErr retErr=RetErr.SERVICE_ERR;
            retErr.msg = "账号或密码错误";
            throw new MyException(retErr);
        }
    }

//    @Override
//    public String refresh(String oldToken) {
//        final String token = oldToken.substring(tokenHead.length());
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
//            return jwtTokenUtil.refreshToken(token);
//        }
//        return null;
//    }
}