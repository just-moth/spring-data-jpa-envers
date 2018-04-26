package com.mndeveci.spring.boot.rest.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * @author： lxh
 * @description：
 * @created: 2018/4/26 14:43
 * @modified by:
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.mndeveci.spring.boot.rest.repository", repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@EnableSpringDataWebSupport
public class JpaDataConfig {

}
