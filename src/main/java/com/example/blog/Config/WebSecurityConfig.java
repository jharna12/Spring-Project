package com.example.blog.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@ConditionalOnProperty(prefix = "azure-sample-spring-boot", value = "9ec57533-cbc1-43fd-9e10-3579b719e953")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	 @Autowired
	    private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService;
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .anyRequest().authenticated()
	            .and()
	            .oauth2Login()
	            .userInfoEndpoint()
	            .oidcUserService(oidcUserService);
	           
	    }

}
