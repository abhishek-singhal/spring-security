/**
 * 
 */
package com.infogain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.dao.UserDao;
import com.infogain.entity.User;

/**
 * @author Abhishek1.Singhal
 *
 */

@Service
public class UserService {
	
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	public User findByUserName(String username) {
		return userDao.findByUsername(username);
	}
	
}
