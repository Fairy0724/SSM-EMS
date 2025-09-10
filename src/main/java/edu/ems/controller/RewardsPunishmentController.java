package edu.ems.controller;

import com.baomidou.mybatisplus.plugins.Page;
import edu.ems.entity.RewardsPunishment;
import edu.ems.service.RewardsPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

//229970615 李松蔓
@Controller
@RequestMapping("/rewardsPunishment")
public class RewardsPunishmentController {

    @Autowired
    private RewardsPunishmentService rewardsPunishmentService;

    @RequestMapping("/listPage.do")
    public String selectListByPgae(Model model, int pageNo){
        Page<RewardsPunishment> page = rewardsPunishmentService.selectListByPage(pageNo);
        model.addAttribute("page",page);
        return "admin/xinzi_list";
    }


    @RequestMapping("/toAdd.do")
    public String toAdd(Model model){
//        List<RewardsPunishment> dList = rewardsPunishmentService.selectList(new EntityWrapper<RewardsPunishment>()
//                .orderBy("employee_number", false));
//        model.addAttribute("rewardsPunishmentNumber", dList.get(0).getEmployeeNumber()+1);
        return "admin/xinzi_add";
    }

    @RequestMapping("/add.do")
    public String add(RewardsPunishment rewardsPunishment){
        rewardsPunishment.setTime(new Date());
        rewardsPunishmentService.insert(rewardsPunishment);
        return "forward:/rewardsPunishment/listPage.do?pageNo=1";
    }

    @RequestMapping("/{id}/delete.do")
    public String deleteById(@PathVariable Integer id){
        rewardsPunishmentService.deleteById(id);
        return "forward:/rewardsPunishment/listPage.do?pageNo=1";
    }
}
