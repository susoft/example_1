package com.example.demo.service;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	//List<User> findByName(String name);
}
