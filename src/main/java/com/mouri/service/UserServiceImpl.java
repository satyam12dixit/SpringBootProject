package com.mouri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouri.entity.UserEntity;
import com.mouri.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepository;

	@Override  //add new User here
	public boolean saveUser(UserEntity userentity) {
		System.out.println("save user method services");
		UserEntity saveentity=userrepository.save(userentity);
		return saveentity.getUserId()!=null;
	}

	@Override // display list of users
	public List<UserEntity> getAllUser() {
		System.out.println("get All Users");
		return userrepository.findAll();
	}

	@Override
	public UserEntity getUserId(Integer uid) {
		System.out.println("get userby id method in service class");
		Optional<UserEntity> optional=userrepository.findById(uid);
		UserEntity userentity=null;
		if(optional.isPresent()) {
			userentity =optional.get();
		}else {
			throw new RuntimeException("User not found for id:"+uid);
		}
		return userentity;
	}

	@Override
	public boolean deleteUserById(Integer uid) {
		System.out.println("delete by user id");
		userrepository.deleteById(uid);
		return false;
	}



}
