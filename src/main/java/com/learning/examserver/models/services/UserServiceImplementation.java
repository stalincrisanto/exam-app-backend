package com.learning.examserver.models.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.examserver.models.dao.IRoleDao;
import com.learning.examserver.models.dao.IUserDao;
import com.learning.examserver.models.entity.User;
import com.learning.examserver.models.entity.UserRole;

@Service
public class UserServiceImplementation implements IUserService {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userDao.findByUserName(user.getUserName());
		if(local!=null) {
			System.out.println("User already exists");
			throw new Exception ("El nombre de usuario ya existe");
		} else {
			//aquí se crea el usuario
			for (UserRole userRole : userRoles) {
				System.out.println("AQUI ESTOY RECORRIENDO EL ARREGLO DE UserRole con "+userRole.getRole().getRoleName());
				roleDao.save(userRole.getRole());
			}
			System.out.println("AQUI SALI DEL FOR Y TENGO ESO DEL user.getUserRoles() "+user.getUserRoles());
			user.getUserRoles().addAll(userRoles);
			local = this.userDao.save(user);
		}
		
		return local;
	}


	public User getUser(String userName) {
		return this.userDao.findByUserName(userName);
	}


	@Override
	public void deleteUser(Long id) {
		
		this.userDao.deleteById(id);
	}

}
