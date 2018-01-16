package com.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boot.entity.User;

@Mapper
public interface UserMapper {

	List<User> queryAll();
}
