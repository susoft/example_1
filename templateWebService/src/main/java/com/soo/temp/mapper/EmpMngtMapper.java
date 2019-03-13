package com.soo.temp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soo.temp.vo.EmpMngt;

@Mapper
public interface EmpMngtMapper {
	List<EmpMngt> selectAll();
}
