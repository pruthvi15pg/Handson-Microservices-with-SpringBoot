//package com.ms.cartpg.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.init.DataSourceInitializer;
//import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//
//import javax.sql.DataSource;
//    @Configuration
//    public class DataSourceConfig {
//
//        @Bean(name = "sourceDataSource")
//        @Qualifier("sourceDataSource")
//        public DataSource sourceDataSource() {
//            return DataSourceBuilder.create()
//                    .url("jdbc:postgresql://source_host:source_port/source_dbname")
//                    .username("source_user")
//                    .password("source_password")
//                    .build();
//        }
//
//        @Bean(name = "targetDataSource")
//        @Qualifier("targetDataSource")
//        public DataSource targetDataSource() {
//            return DataSourceBuilder.create()
//                    .url("jdbc:postgresql://target_host:target_port/target_dbname")
//                    .username("target_user")
//                    .password("target_password")
//                    .build();
//        }
//    }
//
//
//
