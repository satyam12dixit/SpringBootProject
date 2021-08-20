package com.mouri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mouri.entity.UserEntity;
import com.mouri.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//1 Display List Of All Users
	@RequestMapping(name = "/view", method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		model.addAttribute("listusers",userservice.getAllUser());
		return "index";
	}
	
	//we want to add new User 
	@RequestMapping(name ="/addNewUser",method = RequestMethod.GET )
	public String addNewUserForm(Model model) {
		UserEntity userEntity1= new UserEntity();
		model.addAttribute("users", userEntity1);
		return "new_user";
	}
	
	//save user
	public String saveUser(@ModelAttribute("users") UserEntity userentity) {
		//save user data into data base
		userservice.saveUser(userentity);
		return "redirect:/view";
	}
	
	//update the user data
	public String updateFromUser(Model model, @PathVariable("userId")  Integer userId) {
		UserEntity userentityId= new UserEntity();
		model.addAttribute("users", userentityId);
		return "update_user";
	}

	public String deleteFormUser(@PathVariable(value = "userId") Integer userId) {
		userservice.deleteUserById(userId);
		return "redirect:/view";
	}
}
