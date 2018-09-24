package com.igorzavati.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.igorzavati.springbootrestapi.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	
}
