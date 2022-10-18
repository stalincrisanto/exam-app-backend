package com.learning.examserver.models.services;

import java.util.Set;

import com.learning.examserver.models.entity.User;
import com.learning.examserver.models.entity.UserRole;

public interface IUserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//Get user by userName
	public User getUser (String userName);
	
	//Delete User by id
	public void deleteUser (Long id);
}
