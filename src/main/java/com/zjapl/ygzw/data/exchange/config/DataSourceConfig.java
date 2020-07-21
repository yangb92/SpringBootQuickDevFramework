package com.zjapl.ygzw.data.exchange.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 多数据源配置
 * Created by YangBin on 2020/7/21
 * Copyright (c) 2020 杨斌 All rights reserved.
 */
@Configuration
public class DataSourceConfig {

    public SqlSessionFactory buildSqlSessionFactory(String driverClassName,String url,String username,String password,String mapperLocation) throws Exception {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setDriverClassName(driverClassName);
        dataSourceProperties.setUsername(username);
        dataSourceProperties.setPassword(password);
        dataSourceProperties.setUrl(url);
        HikariDataSource datasource = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocation));
        return factoryBean.getObject();
    }

    @Data
    @Configuration
    @ConfigurationProperties("wsbs.datasource")
    @MapperScan(basePackages = "com.zjapl.ygzw.data.exchange.wsbs.dao", sqlSessionFactoryRef = "wsbsSqlSessionFactory")
    class WsbsDataSource{
        private String driverClassName;

        private String url;

        private String username;

        private String password;

        private String mapperLocation;

        @Bean(name = "wsbsSqlSessionFactory")
        public SqlSessionFactory wsbsSqlSessionFactory() throws Exception {
           return buildSqlSessionFactory(this.driverClassName,this.url,this.username,this.password,this.mapperLocation);
        }
    }

    @Data
    @Configuration
    @ConfigurationProperties("zww.datasource")
    @MapperScan(basePackages = "com.zjapl.ygzw.data.exchange.zww.dao", sqlSessionFactoryRef = "zwwSqlSessionFactory")
    public class ZwwDataSourceConfig {

        private String driverClassName;

        private String url;

        private String username;

        private String password;

        private String mapperLocation;

        @Bean(name = "zwwSqlSessionFactory")
        public SqlSessionFactory zwwSqlSessionFactory() throws Exception {
            return buildSqlSessionFactory(this.driverClassName,this.url,this.username,this.password,this.mapperLocation);
        }
    }

}
