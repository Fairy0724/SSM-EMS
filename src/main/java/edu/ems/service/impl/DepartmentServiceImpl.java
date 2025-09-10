package edu.ems.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.ems.entity.Department;
import edu.ems.mapper.DepartmentMapper;
import edu.ems.service.DepartmentService;
//229970615 李松蔓
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> 
	implements DepartmentService{

	@Override
	public Department selectByNumber(Integer departmentNumber) {
		return baseMapper.selectByNumber(departmentNumber);
	}

	@Override//分页的
	public Page<Department> selectListByPage(int pageNo) {
		Page<Department> page = new Page<Department>(pageNo, 10, "id");
		//是否为升序 ASC（ 默认： true ）
		page.setAsc(true);
		page.setRecords(baseMapper.selectPage(page, null));
		return page;
	}

}
