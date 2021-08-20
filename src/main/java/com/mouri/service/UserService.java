package com.mouri.service;

import java.util.List;

import com.mouri.entity.UserEntity;

public interface UserService {

	
	public boolean saveUser(UserEntity userentity);
	
	public List<UserEntity> getAllUser();
	
	public UserEntity getUserId(Integer uid);
	
	public boolean deleteUserById(Integer uid);
}
