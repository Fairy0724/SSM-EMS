package edu.ems.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import edu.ems.entity.Gonggao;
//229970615 李松蔓
public interface GonggaoService extends IService<Gonggao>{
	
	/**
	 * 分页查询所有部门（倒序）
	 * @param pageNo
	 * @return
	 */
	Page<Gonggao> selectListByPage(int pageNo);

	Gonggao getNewGonggao();
	
}
