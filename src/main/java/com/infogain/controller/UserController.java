/**
 * 
 */
package com.infogain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infogain.entity.User;
import com.infogain.service.UserService;


/**
 * @author Abhishek1.Singhal
 *
 */

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(path="/dashboard")
	public String dashboard(Model model) {
		User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", user);
		return "dashboard";
	}
	
	@GetMapping(path="/admin")
	public String adminPage() {
		return "adminPage";
	}
	
	@GetMapping(path="/avg")
	public String averageUser() {
		return "user";
	}
}
