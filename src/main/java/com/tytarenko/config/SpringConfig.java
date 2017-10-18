package com.tytarenko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.tytarenko.service", "com.tytarenko.dao"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
       return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/database?useSll=false");
        dataSource.setUsername("root");
        dataSource.setPassword("2007");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    /** spring сам знайде bean за допопмогою @ComponentScan(basePackages = "")
      * в пакеті, який зазначено в анотації
      */
    /*@Bean
    public UserDao getUserDaoImpl() {
        return new UserDaoImpl(getJdbcTemplate());
    }*/

    /*@Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }*/
}
