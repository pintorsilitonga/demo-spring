package com.example.demo.configuration.security;

import com.example.demo.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DemoProperties demoProperties;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER").and()
                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        final String graphqlApiBasePath = demoProperties.getGraphqlApiBasePath();

        httpSecurity
                .authorizeRequests().antMatchers(graphqlApiBasePath + "/**")
                    .hasAnyRole("ADMIN", "USER").and()
                .httpBasic().and()
                .csrf().disable();
    }
}
