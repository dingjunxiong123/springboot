package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.boot.entity.User;
import com.boot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private Environment evn;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("user/queryAll")
	@ResponseBody
	public String queryAll(){
		List<User> list = userService.queryAll();
		return JSON.toJSONString(list);
	}
	
}
