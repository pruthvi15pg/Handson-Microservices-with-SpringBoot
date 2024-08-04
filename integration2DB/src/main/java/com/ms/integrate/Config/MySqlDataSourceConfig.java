package com.ms.addresspg.Config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MySqlDataSourceConfig {

    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    public DataSourceProperties MySqlDataSourceProperties(){
        return new DataSourceProperties();
    }

    public DataSource mySqlDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(MySqlDataSourceProperties().getDriverClassName());
        dataSource.setUrl(MySqlDataSourceProperties().getUrl());
        dataSource.setUsername(MySqlDataSourceProperties().getUsername());
        dataSource.setPassword(MySqlDataSourceProperties().getPassword());
        return dataSource;
    }



}
