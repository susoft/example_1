package com.soo.temp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Alias("empMngt")
public class EmpMngt {
	private String emp_id;
	private String emp_no;
	private String emp_nm;
	private String usergroup_id;
}
