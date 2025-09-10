package edu.ems.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.ems.entity.*;
import edu.ems.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import edu.ems.util.MTimeUtil;

//229970615 李松蔓
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private GonggaoService gonggaoService;

	@Autowired
	private AttendanceService attendanceService;

	//跳转到登录页面
	@RequestMapping("/login.do")
	public String toLogin(){
		return "login";
	}

	//检查登录
	@RequestMapping("/checkLogin.do")
	public String checkLogin(HttpSession session, Employee employee){
		//调用服务层检查登录
		Employee employee2 = employeeService.checkLogin(employee.getEmployeeNumber(), employee.getPassword());
		if (employee2 != null) {
			//设置登录状态
			session.setAttribute("loged", employee2);
			//根据职位级别跳转页面
			String level = employee2.getPosition().getLevel();
			if (level.equals("HR")) {
				return "main/hr";
			}
			else if (level.equals("系统管理员")) {
				return "main/admin";
			}
			else if (level.equals("部门主管")) {
				return "main/manager";
			}
			//普通员工
			else {
				return "main/emp";
			}
		} else {
			return "login";
		}
	}

	//跳转到欢迎页面
	@RequestMapping("/welcome.do")
	public String toWelcome(Model model){
		Gonggao gonggao = gonggaoService.getNewGonggao();
		model.addAttribute("gonggao",gonggao);
		return "welcome";
	}

	//获取员工列表分页
	@RequestMapping("/listPage.do")
	public String selectList(Model model, int pageNo){
		Page<Employee> page = employeeService.selectListByPage(pageNo);
		model.addAttribute("page", page);
		return "admin/emp/employee_list";
	}

	//获取员工详情
	@RequestMapping("/{id}/detail.do")
	public String selectEmployee(@PathVariable Integer id, Model model){
		Employee employee = employeeService.selectEmployee(id);
		model.addAttribute("employee", employee);
		return "admin/emp/employee_detail";
	}

	//跳转到添加员工页面
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model){
		List<History> eList = historyService.selectList(new EntityWrapper<History>()
				.orderBy("employee_number", false));
		model.addAttribute("employeeNumber",eList.get(0).getEmployeeNumber()+1);
		List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
		model.addAttribute("dList", dList);
		List<Position> pList = positionService.selectList(new EntityWrapper<Position>());
		model.addAttribute("pList", pList);
		return "admin/emp/employee_add";
	}

	//添加员工
	@RequestMapping("/add.do")
	public String add(Employee employee, String date) {
		employee.setBirthday(MTimeUtil.stringParse(date));
		employeeService.addEmployee(employee);
		return "forward:/employee/listPage.do?pageNo=1";
	}

	//跳转到更新员工页面
	@RequestMapping("/{id}/toUpdate.do")
	public String toUpdate(Model model, @PathVariable Integer id){
		Employee employee = employeeService.selectById(id);
		model.addAttribute("employee", employee);
		List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
		model.addAttribute("dList", dList);
		List<Position> pList = positionService.selectList(new EntityWrapper<Position>());
		model.addAttribute("pList", pList);
		return "admin/emp/employee_update";
	}

	//更新员工
	@RequestMapping("/{id}/update.do")
	public String updateById(@PathVariable Integer id, Employee employee, String date, String status, 
			HttpSession session){
		employee.setId(id);
		employee.setBirthday(MTimeUtil.stringParse(date));
		//得到操作人员的名字
		Employee employee2 = (Employee) session.getAttribute("loged");
		employeeService.updateEmployee(employee, status, employee2.getName());
		return "forward:/employee/listPage.do?pageNo=1";
	}

	//删除员工
	@RequestMapping("/{id}/delete.do")
	public String deleteById(@PathVariable Integer id){
		employeeService.deleteEmployee(id);
		return "forward:/employee/listPage.do?pageNo=1";
	}

	//获取员工个人详情
	@RequestMapping("/oneself/{id}/detail.do")
	public String selectEmployee2(@PathVariable Integer id, Model model){
		Employee employee = employeeService.selectEmployee(id);
		model.addAttribute("employee", employee);
		return "admin/self/oneself_detail";
	}


	//跳转到员工个人更新页面
	@RequestMapping("/oneself/{id}/toUpdate.do")
	public String toUpdate2(Model model, @PathVariable Integer id){
		Employee employee = employeeService.selectById(id);
		model.addAttribute("employee", employee);
		return "admin/self/oneself_update";
	}

	//搜索员工
	@RequestMapping("/search")
	public String search(Model model, String input, int pageNo){
		Page<Employee> page = employeeService.search(input, pageNo);
		model.addAttribute("page", page);
		return "admin/emp/search_result";
	}

	//退出登录
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("loged");
		return "login";
	}

}
