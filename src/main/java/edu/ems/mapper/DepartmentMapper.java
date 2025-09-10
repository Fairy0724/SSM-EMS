package edu.ems.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import edu.ems.entity.Department;

//229970615 李松蔓
public interface DepartmentMapper extends BaseMapper<Department>{

	/**
	 * 根据DepartmentNumber查询信息
	 * @param departmentNumber
	 * @return
	 */

	Department selectByNumber(Integer departmentNumber);
}
