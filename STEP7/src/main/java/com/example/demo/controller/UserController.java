package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

//ユーザー情報
@Controller

public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//ユーザー情報一覧表示
	@GetMapping(value = "/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist",userlist);
		return "user/list";
		
	}
	
	//ユーザー新規登録画面表示
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest",new UserRequest());
		return "user/add";
	}
	
	//ユーザー新規登録画面
	@RequestMapping(value = "/user/create",method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserRequest userRquest,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			//入力エラーチェック
			List<String>errorList = new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAllAttributes("validationError",errorList);
			model.addAttribute("userRequest", UserRequest);
			return "user/add";
		}
		//ユーザー登録
		userService.create(userRequest);
		return "redirect:/user/list";
	}
	
	//ユーザー詳細画面を表示
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id,Model model) {
		return "user/view";
		
	}

}
