package com.learning.examserver.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.examserver.models.entity.Role;

public interface IRoleDao extends JpaRepository<Role, Long> {

}
