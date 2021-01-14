package com.ivoronline.springboot_security_class.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {

    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("myadmin")
        .password("myadminpassword")
        .roles("ADMIN")
        .build();

    UserDetails user = User.withDefaultPasswordEncoder()
        .username("myuser")
        .password("myuserpassword")
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(admin, user);

  }

}



