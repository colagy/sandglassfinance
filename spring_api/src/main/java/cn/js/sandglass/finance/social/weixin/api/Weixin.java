package cn.js.sandglass.finance.social.weixin.api;

public interface Weixin {
    WeixinUserInfo getUserInfo(String unionId);
}