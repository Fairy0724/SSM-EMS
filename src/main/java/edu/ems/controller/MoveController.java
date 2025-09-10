package edu.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ems.entity.Move;
import edu.ems.service.MoveService;

//229970615 李松蔓
@Controller
@RequestMapping("/move")
public class MoveController {

	@Autowired
	private MoveService moveService;
	
	@RequestMapping("/list.do")
	public String selectList(Model model){
		List<Move> list = moveService.selectList();
		model.addAttribute("mList",list);
		return "admin/move/move_list";
	}
	
}
