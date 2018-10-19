/**
 * 
 */
package com.infogain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Abhishek1.Singhal
 *
 */

@Controller
public class HomeController {
	
	@GetMapping(path="/")
	public String homePage() {
		return "homePage";
	}
}
