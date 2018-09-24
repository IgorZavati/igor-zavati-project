package com.igorzavati.springbootrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorzavati.springbootrestapi.dao.UserDAO;
import com.igorzavati.springbootrestapi.model.User;

@RestController
@RequestMapping("/aplication")
public class UserController {
	
	@Autowired
	UserDAO userDao;
	@PostMapping("/usuario")
	public User createUser(@Valid @RequestBody User user){
		
		return userDao.create(user);
		
	}
	@GetMapping("/usuario")
	public List<User>getAllUsuarios(){
		return userDao.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Long userid){
		User user = userDao.findbyId(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Long userid,@Valid @RequestBody User userDetalis){ 
		User user = userDao.findbyId(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		user.setNome(userDetalis.getNome());
		user.setSenha(userDetalis.getSenha());
		user.setDataInicial(userDetalis.getDataInicial());
		
		User updateUser = userDao.create(user);
	  return ResponseEntity.ok().body(updateUser);
	  }
	
	@DeleteMapping("/usuario/{id}")
	private ResponseEntity<User> deleteUsere(@PathVariable(value="id")Long userid){
		User user = userDao.findbyId(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		 }
		userDao.deleteUser(user);
		return ResponseEntity.ok().build();
	  }
	}
