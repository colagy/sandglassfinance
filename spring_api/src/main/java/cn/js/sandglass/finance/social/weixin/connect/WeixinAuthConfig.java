package cn.js.sandglass.finance.social.weixin.connect;

@Configuration
public class WeixinAuthConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ConnectionSignUp myConnectionSignUp;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new WeixinConnectionFactory(DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID, SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_ID,
                SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_SECRET);
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator, Encryptors.noOpText());
        if (myConnectionSignUp != null) {
            repository.setConnectionSignUp(myConnectionSignUp);
        }
        return repository;
    }

    /**
     * /connect/weixin POST请求,绑定微信返回connect/weixinConnected视图
     * /connect/weixin DELETE请求,解绑返回connect/weixinConnect视图
     * @return
     */
    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    @ConditionalOnMissingBean(name = "weixinConnectedView")
    public View weixinConnectedView() {
        return new SocialConnectView();
    }

}