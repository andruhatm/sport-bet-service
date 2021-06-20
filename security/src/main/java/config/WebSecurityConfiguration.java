package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import config.secure.FIlterForJwt;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * Класс кофигурации для модуля Security
 *
 * @author andruha.tm
 */
@Configuration
@ComponentScan
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final FIlterForJwt fIlterForJwt;

  public WebSecurityConfiguration(FIlterForJwt fIlterForJwt) {
    this.fIlterForJwt = fIlterForJwt;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .httpBasic().disable()
      .csrf().disable()
      .sessionManagement().sessionCreationPolicy(STATELESS)
      .and()
      .authorizeRequests()
      .antMatchers("/api/").permitAll()
      .antMatchers("/", "/register", "/favicon.ico", "/css/**", "/js/**", "/images/**").permitAll()
      .antMatchers("/api/picture").permitAll()
      .antMatchers(POST, "/ru.student.security.security/*").anonymous()
//      .antMatchers(POST, "/ru.student.security.security/").permitAll()
      .antMatchers(POST, "/ru.student.security.security/login").permitAll()
      .antMatchers(GET, "/user/events").permitAll()
      .antMatchers(GET, "/user/*/bets").authenticated()
      .antMatchers(GET, "/user/events").permitAll()
      .antMatchers(GET, "/user/*").permitAll()
      .antMatchers(POST, "/bets/").authenticated()

      // Добавить новые методы
      .and()
      .addFilterBefore(fIlterForJwt, UsernamePasswordAuthenticationFilter.class)
      .logout()
      .logoutUrl("/security/logout")
      .permitAll()
      .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.setStatus(HttpServletResponse.SC_OK));

  }
}
