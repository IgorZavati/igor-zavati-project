package com.igorzavati.springbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorzavati.springbootrestapi.model.User;
import com.igorzavati.springbootrestapi.repository.UserRepository;

@Service
public class UserDAO {
	@Autowired
	UserRepository userRepository;
	
	/* create User */

	public User create(User user) {
		return userRepository.save(user);
	}
	
	/* Listar User */
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	/* Buscar por ID  */
	
	public User findbyId(Long userid) {
		return userRepository.findOne(userid);
	}
	/*Delete User */
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
}
