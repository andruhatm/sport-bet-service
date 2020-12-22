package ru.student.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.student.data.DataConfiguration;
import ru.student.security.WebSecurityConfiguration;

@SpringBootApplication
@Import({
  DataConfiguration.class,
  WebSecurityConfiguration.class
})
public class SportBetsApp extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(SportBetsApp.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(SportBetsApp.class,args);
  }
}
