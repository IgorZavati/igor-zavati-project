package com.igorzavati.springjpaPostgresSQL.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.igorzavati.springjpaPostgresSQL.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findbyLastName(String lastName);

}
