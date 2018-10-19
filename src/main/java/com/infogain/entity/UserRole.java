/**
 * 
 */
package com.infogain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abhishek1.Singhal
 *
 */

@Entity
@Table(name="user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String role;
	
	public UserRole() {
	
	}
	public UserRole(String role) {
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
