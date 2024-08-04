package com.ms.addresspg.Config;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;



    @Configuration
    @EnableCaching
    public class RedisConfig {
        @Bean
        public LettuceConnectionFactory connectionFactory() {
            RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
            configuration.setHostName(properties().getHost());
            configuration.setPort(properties().getPort());
            return new LettuceConnectionFactory(configuration);
        }

//        @Bean
//        public JedisConnectionFactory connectionFactory() {
//            RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//            configuration.setHostName("localhost");
//            configuration.setPort(6379);
//            return new JedisConnectionFactory(configuration);
//        }

        @Bean
        @Primary
        public RedisProperties properties() {
            return new RedisProperties();
        }

//        @Bean
//        public RedisTemplate<String, Object> template() {
//            RedisTemplate<String, Object> template = new RedisTemplate<>();
//            template.setConnectionFactory(connectionFactory());
//            template.setKeySerializer(new StringRedisSerializer());
//            template.setHashKeySerializer(new StringRedisSerializer());
//            template.setHashKeySerializer(new JdkSerializationRedisSerializer());
//            template.setValueSerializer(new JdkSerializationRedisSerializer());
//            template.setEnableTransactionSupport(true);
//            template.afterPropertiesSet();
//            return template;
//        }

        @Bean
        public RedisTemplate<String,Object> redisTemplate() {
            RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
            redisTemplate.setConnectionFactory(connectionFactory());
            redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
            redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
            return  redisTemplate;
        }

    }

