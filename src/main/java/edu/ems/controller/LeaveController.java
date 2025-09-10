package edu.ems.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import edu.ems.entity.Employee;
import edu.ems.entity.Leave;
import edu.ems.service.LeaveService;
import edu.ems.util.MTimeUtil;

// 229970615 李松蔓
// 请假相关功能的控制器类
@Controller
@RequestMapping("/leave")
public class LeaveController {
	// 自动注入请假业务逻辑服务对象
	@Autowired
	private LeaveService leaveService;

	// 获取所有请假记录，返回请假记录列表页面
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		model.addAttribute("list", leaveService.selectList());
		return "admin/leave/leave_list";
	}

	// 根据请假记录id获取详情，返回请假记录详情页面
	@RequestMapping("/{id}/detail.do")
	public String selectLeave(@PathVariable Integer id, Model model) {
		model.addAttribute("leave", leaveService.selectLeave(id));
		return "admin/leave/leave_detail";
	}

	// 根据请假记录id更新状态，转发到未批准请假记录列表页面
	@RequestMapping("/{id}/update.do")
	public String updateStatus(@PathVariable Integer id) {
		leaveService.updateStatus(id);
		return "forward:/leave/notlist.do";
	}

	// 根据请假记录id更新状态，转发到未批准请假记录列表页面
	@RequestMapping("/{id}/update1.do")
	public String updateStatus1(@PathVariable Integer id) {
		leaveService.updateStatus1(id);
		return "forward:/leave/dontlist.do";
	}

	// 跳转到添加请假记录的页面
	@RequestMapping("/toAdd.do")
	public String toAdd() {
		return "admin/leave/leave_add";
	}

	// 处理添加请假记录请求，转发到员工欢迎页面
	@RequestMapping("/add.do")
	public String add(Integer employeeNumber, Leave leave, String start, String end, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("loged");
		leave.setDepartmentNumber(employee.getDepartmentNumber());
		leave.setEmployeeNumber(employeeNumber);
		leave.setStartTime(MTimeUtil.stringParse(start));
		leave.setEndTime(MTimeUtil.stringParse(end));
		leaveService.insert(leave);
		return "forward:/employee/welcome.do";
	}

	// 根据员工编号分页查询其请假记录，返回员工个人请假记录页面
	@RequestMapping("/oneself.do")
	public String selectByEmployee(HttpSession session, int pageNo, Model model) {
		Employee employee = (Employee) session.getAttribute("loged");
		model.addAttribute("page", leaveService.seletByEmployee(employee.getEmployeeNumber(), pageNo));
		return "admin/self/oneself_leave";
	}

	// 获取当前登录员工所在部门未批准的请假记录，返回未批准请假记录列表页面
	@RequestMapping("/notlist.do")
	public String selectNotList(Model model, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("loged");
		model.addAttribute("list", leaveService.selectListByStatus(employee.getDepartmentNumber(), "未批准"));
		return "admin/leave/leave_notlist";
	}

	// 获取当前登录员工所在部门已批准的请假记录，返回已批准请假记录列表页面
	@RequestMapping("/yeslist.do")
	public String selectYesList(Model model, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("loged");
		model.addAttribute("list", leaveService.selectListByStatus(employee.getDepartmentNumber(), "已批准"));
		return "admin/leave/leave_yeslist";
	}


	@RequestMapping("/dontlist.do")
	public String selectDontList(Model model, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("loged");
		model.addAttribute("list", leaveService.selectListByStatus(employee.getDepartmentNumber(), "不批准"));
		return "admin/leave/leave_dontlist";
	}
}