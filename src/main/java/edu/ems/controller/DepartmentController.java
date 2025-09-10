package edu.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import edu.ems.entity.Department;
import edu.ems.service.DepartmentService;

//229970615 李松蔓
// Spring MVC控制器，处理部门相关请求
@Controller
@RequestMapping("/department")
public class DepartmentController {

	//注入部门服务对象
	@Autowired
	private DepartmentService departmentService;

	//获取部门列表分页
	@RequestMapping("/listPage.do")
	public String selectListByPgae(Model model, int pageNo){
		Page<Department> page = departmentService.selectListByPage(pageNo);
		model.addAttribute("page",page);
		return "admin/dept/department_list";
	}

	//跳转到添加部门页面
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model){
		List<Department> dList = departmentService.selectList(new EntityWrapper<Department>()
				.orderBy("department_number", false));
		model.addAttribute("departmentNumber", dList.get(0).getDepartmentNumber()+1);
		return "admin/dept/department_add";
	}

	//添加部门
	@RequestMapping("/add.do")
	public String add(Department department){
		departmentService.insert(department);
		return "forward:/department/listPage.do?pageNo=1";
	}

	//跳转到更新部门页面
	@RequestMapping("/{id}/toUpdate.do")
	public String toUpdate(@PathVariable Integer id, Model model){
		Department department = departmentService.selectById(id);
		model.addAttribute("department", department);
		return "admin/dept/department_update";
	}

	//更新部门
	@RequestMapping("/{id}/update.do")
	public String updateById(@PathVariable Integer id, Department department){
		department.setId(id);
		departmentService.updateById(department);
		return "forward:/department/listPage.do?pageNo=1";
	}

	//删除部门
	@RequestMapping("/{id}/delete.do")
	public String deleteById(@PathVariable Integer id){
		departmentService.deleteById(id);
		return "forward:/department/listPage.do?pageNo=1";
	}

}
