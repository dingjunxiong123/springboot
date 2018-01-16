package com.boot.mybatis.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.boot.mybatis.DescriptionID;
import com.boot.mybatis.SqlSessionFactoryBean;
import com.boot.mybatis.typehandler.ArrayIntToStringTypeHandler;
import com.boot.mybatis.typehandler.ArrayLongToStringTypeHandler;
import com.boot.mybatis.typehandler.ArrayToStringTypeHandler;
import com.boot.mybatis.typehandler.CalendarTypeHandler;
import com.boot.mybatis.typehandler.GenericEnumTypeHandler;
import com.boot.mybatis.typehandler.ListStringTypeHandler;

@Configuration
@MapperScan("com.boot.mapper")
public class SessionFactoryConfig {

	//指定 MyBatis 的 XML 配置文件路径
	private static String ConfigLocation = "/mybatisMapper/mybatis-config.xml";
	//加载resource
	private static String MapperLocations = "/mybatisMapper/mapper/*Mapper.xml";
	//实体类包路径
	private static String TypeAliasesPackage = "com.boot.entity";
	//类型加载器包路径
	private static String TypeHandlersPackage = "com.boot.mybatis.typehandler";
	//枚举包路径
	private static String ScanEnumPackage = "com.boot.enumerated";
	
	@Autowired
	private DataSource dataSource;
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		//在基本的 MyBatis 中,session 工厂可以使用 SqlSessionFactoryBuilder 来创建。而在 MyBatis-Spring 中,则使用 SqlSessionFactoryBean 来替代
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		//指定 MyBatis 的 XML 配置文件路径  通常这会是<settings> 或<typeAliases>的部分
		bean.setConfigLocation(new ClassPathResource(ConfigLocation));
		//加载resource
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		String mapperLocationsPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MapperLocations;
		bean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(mapperLocationsPath));
		//数据源
		bean.setDataSource(dataSource);
		//实体类包路径
		bean.setTypeAliasesPackage(TypeAliasesPackage);
		//类型处理器路径
		bean.setTypeHandlersPackage(TypeHandlersPackage);
		//类型处理器
		TypeHandler[] typeHandlers = {
				new ArrayIntToStringTypeHandler(),
				new ArrayLongToStringTypeHandler(),
				new ArrayToStringTypeHandler(),
				new CalendarTypeHandler(),
				new GenericEnumTypeHandler<DescriptionID>(),
				new ListStringTypeHandler()
		};
		bean.setTypeHandlers(typeHandlers);
		//枚举
		Map<String, String> scanMap = new HashMap<String, String>();
		scanMap.put("enumToInt", ScanEnumPackage);
		bean.setTypeScanMap(scanMap);
		return bean;
	}
}
