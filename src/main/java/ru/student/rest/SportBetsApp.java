package ru.student.rest;

import config.WebSecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.student.data.DataConfiguration;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Главный класс из которого происходит инициализация основного контекста приложения.
 * Данный модуль будет являться верхним уровнем приложения. В нем будут реализованы все конечные точки нашего REST API.
 *
 * @author andruha.tm
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
@EnableScheduling
@Import({
  DataConfiguration.class,
  WebSecurityConfiguration.class,
  BeanValidatorPluginsConfiguration.class
})
public class SportBetsApp {

  @Bean
  public Docket swagger() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any())
      .build();
  }

  public static void main(String[] args) {
    SpringApplication.run(SportBetsApp.class, args);
  }
}
