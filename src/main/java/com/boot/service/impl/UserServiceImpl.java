package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.boot.entity.User;
import com.boot.mapper.UserMapper;
import com.boot.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> queryAll() {
		List<User> list = userMapper.queryAll();
		return list;
	}

}
