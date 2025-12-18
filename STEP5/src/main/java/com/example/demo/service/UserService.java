package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

	//ユーザー情報
	@Service
	public class UserService{

		//ユーザー情報repository

		@Autowired
		private UserRepository userRepository;

		//ユーザー情報　全検索
		public List<User> searchAll() {
			return userRepository.findAll();
		}
	}


