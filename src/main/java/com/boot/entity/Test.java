package com.boot.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * 加载yaml配置文件的方法
 * spring-boot更新到1.5.2版本后locations属性无法使用
 * @PropertySource注解只可以加载proprties文件,无法加载yaml文件
 * 故现在把数据放到application.yml文件中,spring-boot启动时会加载
 */
@Component
@PropertySource(value={"classpath:/config/my.properties"},encoding="UTF-8",ignoreResourceNotFound=false)
@ConfigurationProperties(prefix="my")
public class Test {

	@Value("${my.simpleProp}")
	private String simpleProp;
	@Value("${my.arrayProps}")
    private String[] arrayProps;
	
    private List<String> listProp2 = new ArrayList<String>(); //接收prop2里面的属性值
    
	public String getSimpleProp() {
        return simpleProp;
    }

    //String类型的一定需要setter来接收属性值；maps, collections, 和 arrays 不需要
    public void setSimpleProp(String simpleProp) {
        this.simpleProp = simpleProp;
    }

    public String[] getArrayProps() {
        return arrayProps;
    }

    public void setArrayProps(String[] arrayProps) {
        this.arrayProps = arrayProps;
    }

    public List<String> getListProp2() {
        return listProp2;
    }

    public void setListProp2(List<String> listProp2) {
        this.listProp2 = listProp2;
    }

	
}
