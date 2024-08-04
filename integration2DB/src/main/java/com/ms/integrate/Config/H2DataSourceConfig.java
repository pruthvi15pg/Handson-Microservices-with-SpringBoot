package com.ms.addresspg.Config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class H2DataSourceConfig {

    @ConfigurationProperties("spring.datasource.h2")
    @Bean
    public DataSourceProperties H2DataSourceProperties(){
        return new DataSourceProperties();
    }
//U can create bean for datasource in 2 ways
//1st way
// @Bean
//    public DataSource h2DataSource(){
//        DriverManagerDataSource dataSource=new DriverManagerDataSource();
//        dataSource.setDriverClassName(H2DataSourceProperties().getDriverClassName());
//        dataSource.setUrl(H2DataSourceProperties().getUrl());
//        dataSource.setUsername(H2DataSourceProperties().getUsername());
//        dataSource.setPassword(H2DataSourceProperties().getPassword());
//        return dataSource;
//    }

    //2nd way using the DataSourceProperties's initializeDataSourceBuilder()
    @Bean
    public DataSource h2DataSource(){
        return H2DataSourceProperties().initializeDataSourceBuilder().build();
    }


}
