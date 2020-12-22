package ru.student.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new Pbkdf2PasswordEncoder("", 178_123, 512);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeRequests()
        .antMatchers("/","/register","/favicon.ico").permitAll()
        .anyRequest().authenticated()
      .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
      .and()
        .logout()
        .permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
      .dataSource(dataSource)
      .passwordEncoder(NoOpPasswordEncoder.getInstance())
      .usersByUsernameQuery("SELECT username, password, active FROM \"clients\" WHERE username = ?")
      .authoritiesByUsernameQuery("SELECT cl.username, ur.roles FROM \"clients\" cl inner join \"user_role\" ur on cl.client_id = ur.user_id WHERE cl.username = ?");
  }

  @Bean(name = "multipartResolver")
  public CommonsMultipartResolver getCommonsMultipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(20971520);   // 20MB
    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
    return multipartResolver;
  }



//  @Bean(name="entityManagerFactory")
//  public LocalSessionFactoryBean sessionFactory() {
//
//    return new LocalSessionFactoryBean();
//  }
}
