package com.example.demo.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
	public List<Emp> findAllByOrderByIdDesc();
}
