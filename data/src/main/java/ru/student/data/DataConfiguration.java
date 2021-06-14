package ru.student.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Данный модуль является нижнем уровнем сервера. В нем будет происходить всё взаимодействие с базой данных.
 *
 * @author andruha.tm
 */
@Configuration
@ComponentScan
@EntityScan(basePackages = "ru.student.data.model")
@EnableJpaRepositories(basePackages = "ru.student.data.repo")
public class DataConfiguration {
}
