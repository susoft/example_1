package com.soo.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soo.temp.mapper.EmpMngtMapper;
import com.soo.temp.vo.EmpMngt;

@Service
@Transactional
public class EmpMngtService {
	@Autowired
	EmpMngtMapper empMngtMapper;
	
	public List<EmpMngt> getAll() {
        return empMngtMapper.selectAll();
    }
}
