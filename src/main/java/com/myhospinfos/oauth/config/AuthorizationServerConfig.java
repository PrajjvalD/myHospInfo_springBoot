package com.myhospinfos.oauth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import javax.sql.DataSource;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired 
	BCryptPasswordEncoder encoder;
	@Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;
  
	 @Override
	    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	    }
	
	 @Override
	    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        //final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
	        //tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
	        //endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain).authenticationManager(authManager);
		 endpoints.tokenStore(tokenStore()).authenticationManager(authManager);
	    }

	   @Bean
	    @Primary
	    public DefaultTokenServices tokenServices() {
	        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	        defaultTokenServices.setTokenStore(tokenStore());
	        defaultTokenServices.setSupportRefreshToken(true);
	        return defaultTokenServices;
	    }

	  
	 @Override
	    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
	        clients.jdbc(dataSource).passwordEncoder(encoder);
	    }
	 @Bean
	    public TokenStore tokenStore() {
	        return new JdbcTokenStore(dataSource);
	    }
	    

}