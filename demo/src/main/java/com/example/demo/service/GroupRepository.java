package com.example.demo.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
	Page<Group> findByEmpId(Integer userId, Pageable pageable);
    Optional<Group> findByIdAndEmpId(Integer id, Integer userId);
}
