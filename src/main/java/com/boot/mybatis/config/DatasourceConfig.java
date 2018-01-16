package com.boot.mybatis.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value="classpath:/config/jdbc_mysql.properties",encoding="UTF-8",ignoreResourceNotFound=true)
@MapperScan(basePackages="com.boot.mapper",sqlSessionFactoryRef="sqlSessionFactory")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DatasourceConfig {

	@Autowired
	private Environment env;
	
	@Bean(name="dataSource")
	public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();
		datasource.setDriverClassName(env.getProperty("jdbc.driverClass"));
		datasource.setUrl(env.getProperty("jdbc.url"));
		datasource.setUsername(env.getProperty("jdbc.username"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		return datasource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
