package com.ivoronline.springboot_security_class.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {

    //CREATE ADMIN
    UserDetails admin = User.withDefaultPasswordEncoder()
      .username("myadmin")
      .password("myadminpassword")
      .roles   ("ADMIN")
      .build();

    //CREATE USER
    UserDetails user = User.withDefaultPasswordEncoder()
      .username("myuser")
      .password("myuserpassword")
      .roles   ("USER")
      .build();

    //ADD USERS
    InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(admin, user);

    //RETURN USERS
    return inMemoryUserDetailsManager;

  }

}



