package com.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.security")
public class DatabaseConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Value("jdbc:mysql://localhost:3306/myuser?autoReconnect=true&useUnicode=true&characterEncoding=UTF8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
    private String url;

    @Value("com.mysql.cj.jdbc.Driver")
    private String classname;

    @Value("root")
    private String username;

    @Value("root")
    private String password;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(classname);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }
}
