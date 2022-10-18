package com.learning.examserver.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.examserver.models.entity.Role;
import com.learning.examserver.models.entity.User;
import com.learning.examserver.models.entity.UserRole;
import com.learning.examserver.models.services.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/")
	public User createUser (@RequestBody User user) throws Exception {
		
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(1L);
		role.setRoleName("ADMIN");
		
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	@GetMapping("/{userName}")
	public User getUser (@PathVariable("userName") String userName) {
		return this.userService.getUser(userName);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser (@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
}
