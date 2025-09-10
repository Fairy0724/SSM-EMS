package edu.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ems.entity.Attendance;
import edu.ems.service.AttendanceService;

//229970615 李松蔓
// 定义Spring MVC控制器，处理考勤相关请求
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	// 新增考勤开始记录，处理完转发到员工欢迎页
	@RequestMapping("/addStart.do")
	public String addStart(Integer employeeNumber) {
		attendanceService.addStart(employeeNumber);
		return "forward:/employee/welcome.do";
	}

	// 新增考勤结束记录，处理完转发到员工欢迎页
	@RequestMapping("/addEnd.do")
	public String addEnd(Integer employeeNumber) {
		attendanceService.addEnd(employeeNumber);
		return "forward:/employee/welcome.do";
	}

	// 获取所有考勤记录，添加到模型，返回考勤列表视图
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		List<Attendance> list = attendanceService.selectList();
		model.addAttribute("aList", list);
		return "admin/attendance/attendance_list";
	}

	@RequestMapping("/list1.do")
	public String selectList1(Model model) {
		List<Attendance> list = attendanceService.selectList1();
		model.addAttribute("aList", list);
		return "admin/attendance/attendance_list1";
	}

	// 根据员工号获取其个人考勤记录，添加到模型，返回对应视图
	@RequestMapping("/{employeeNumber}/oneself.do")
	public String select(Model model, @PathVariable Integer employeeNumber) {
		List<Attendance> list = attendanceService.selectByEmployee(employeeNumber);
		model.addAttribute("aList", list);
		return "admin/self/oneself_attendance";
	}


}