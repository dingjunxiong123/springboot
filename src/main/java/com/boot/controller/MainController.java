package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.boot.config.Config;
import com.boot.entity.Test;

@Controller
public class MainController {
	
	@Autowired
	private Test test;
	
	@Autowired
	private Config config;

	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "<h1>Hello, Spring boot</h1>";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		
		return "自动注入："+ JSON.toJSONString(test);
	}
	
	@RequestMapping("/config")
	@ResponseBody
	public String config(){
		return JSON.toJSONString(config);
	}
	
	
}
