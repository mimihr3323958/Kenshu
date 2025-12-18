package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

//ユーザー情報
@Service
@Transactional(rollbackFor = Exception.class)

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User>searchAll(){
		return userRepository.findAll();
	}
	
	//ユーザー新規登録
	
	  public User findById(Long id) {
		    return userRepository.findById(id).get();
		  }
	
	  public void update(UserUpdateRequest userUpdateRequest) {
		    User user = findById(userUpdateRequest.getId());
		    user.setAddress(userUpdateRequest.getAddress());
		    user.setName(userUpdateRequest.getName());
		    user.setPhone(userUpdateRequest.getPhone());
		    user.setUpdateDate(new Date());
		    userRepository.save(user);
		
	}

}
