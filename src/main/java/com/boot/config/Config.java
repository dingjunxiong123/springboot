package com.boot.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value={"classpath:/config/config.properties"},encoding="UTF-8",ignoreResourceNotFound=false)
public class Config {

	@Value("${apath}")
	private String apath;
	
	@Value("${bpath}")
	private String bpath;
	
	@Value("${cpath}")
	private String cpath;

	public String getApath() {
		return apath;
	}

	public void setApath(String apath) {
		this.apath = apath;
	}

	public String getBpath() {
		return bpath;
	}

	public void setBpath(String bpath) {
		this.bpath = bpath;
	}

	public String getCpath() {
		return cpath;
	}

	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
	
	
}
