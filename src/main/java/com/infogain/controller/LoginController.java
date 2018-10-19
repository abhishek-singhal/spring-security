/**
 * 
 */
package com.infogain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.infogain.dao.UserDao;
import com.infogain.entity.User;
import com.infogain.entity.UserRole;

/**
 * @author Abhishek1.Singhal
 *
 */

@Controller
public class LoginController {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping(path="/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping(path="/signup")
	public String signupForm(Model model) {
		model.addAttribute("user", new User());
		return "signupForm";
	}
	
	@PostMapping(path="/signup")
	public String signup(@ModelAttribute("user") User theUser) {
		UserRole userRole = new UserRole("ROLE_USER");
		theUser.setPassword("{bcrypt}"+BCrypt.hashpw(theUser.getPassword(), BCrypt.gensalt()));
		theUser.addRoles(userRole);
		userDao.save(theUser);
		return "redirect:/";
	}
}
