/**
 * 
 */
package com.infogain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.entity.User;
import java.lang.String;

/**
 * @author Abhishek1.Singhal
 *
 */

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
}
