package edu.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.plugins.Page;
import edu.ems.entity.Gonggao;
import edu.ems.service.GonggaoService;

//229970615 李松蔓
// GonggaoController类，用于处理公告相关的业务逻辑
@Controller
@RequestMapping("/gonggao")
public class GonggaoController {

    // 通过依赖注入获取 GonggaoService实例，用于处理公告业务
    @Autowired
    private GonggaoService gonggaoService;

    // 处理查询公告列表分页的请求
    @RequestMapping("/listPage.do")
    public String selectListByPage(Model model, int pageNo) {
        //调用 GonggaoService的方法获取分页数据
        Page<Gonggao> page = gonggaoService.selectListByPage(pageNo);
        //将分页数据添加到Model中，方便视图层使用
        model.addAttribute("page", page);
        //返回公告列表视图
        return "admin/gonggao/gonggao_list";
    }


    // 处理跳转到添加公告页面的请求
    @RequestMapping("/toAdd.do")
    public String toAdd(Model model) {
        //返回添加公告页面视图
        return "admin/gonggao/gonggao_add";
    }

    // 处理添加公告的请求
    @RequestMapping("/add.do")
    public String add(Gonggao gonggao) {
        //调用 GonggaoService的方法添加公告
        gonggaoService.insert(gonggao);
        //添加成功后转发到公告列表页面
        return "forward:/gonggao/listPage.do?pageNo=1";
    }

    // 处理跳转到更新公告页面的请求
    @RequestMapping("/{id}/toUpdate.do")
    public String toUpdate(@PathVariable String id, Model model) {
        //根据公告ID获取公告对象
        Gonggao gonggao = gonggaoService.selectById(id);
        //将公告对象添加到Model中，方便视图层使用
        model.addAttribute("gonggao", gonggao);
        //返回更新公告页面视图
        return "admin/gonggao/gonggao_update";
    }

    // 处理更新公告的请求
    @RequestMapping("/{id}/update.do")
    public String updateById(@PathVariable Integer id, Gonggao gonggao) {
        //设置公告ID
        gonggao.setId(id);
        //调用 GonggaoService的方法更新公告
        gonggaoService.updateById(gonggao);
        //更新成功后转发到公告列表页面
        return "forward:/gonggao/listPage.do?pageNo=1";
    }

    // 处理删除公告的请求
    @RequestMapping("/{id}/delete.do")
    public String deleteById(@PathVariable Integer id) {
        //调用 GonggaoService的方法删除公告
        gonggaoService.deleteById(id);
        //删除成功后转发到公告列表页面
        return "forward:/gonggao/listPage.do?pageNo=1";
    }
}