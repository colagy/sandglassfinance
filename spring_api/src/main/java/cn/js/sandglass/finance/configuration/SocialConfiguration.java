package cn.js.sandglass.finance.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.sql.DataSource;

@Configuration
@EnableSocial
public class SocialConfiguration implements SocialConfigurer {

    @Inject
    private DataSource dataSource;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {

        cfConfig.addConnectionFactory(new LinkedInConnectionFactory(env.getProperty("linkedin.consumerKey"), env.getProperty("linkedin.consumerSecret")));

    }

    @Override
    public UserIdSource getUserIdSource() {

        return new UserIdSource() {

            @Override
            public String getUserId() {

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                if (authentication == null) {

                    throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");

                }

                return authentication.getName();

            }

        };

    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {

        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());

    }

}