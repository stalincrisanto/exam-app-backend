package com.learning.examserver.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.examserver.models.entity.User;

public interface IUserDao extends JpaRepository<User, Long>{
	
	public User findByUserName(String userName);
	
}
