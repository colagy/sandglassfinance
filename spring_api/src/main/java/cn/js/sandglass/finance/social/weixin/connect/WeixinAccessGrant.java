package cn.js.sandglass.finance.social.weixin.connect;

@Data
public class WeixinAccessGrant extends AccessGrant{

    private String openId;

    public WeixinAccessGrant() {
        super("");
    }

    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }
}