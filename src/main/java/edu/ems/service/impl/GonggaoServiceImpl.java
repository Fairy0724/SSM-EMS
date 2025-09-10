package edu.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.ems.entity.Gonggao;
import edu.ems.mapper.GonggaoMapper;
import edu.ems.service.GonggaoService;
//229970615 李松蔓
@Service("gonggaoService")
public class GonggaoServiceImpl extends ServiceImpl<GonggaoMapper, Gonggao> 
	implements GonggaoService{

	@Autowired
	private GonggaoMapper gonggaoMapper;
	
	@Override
	public Page<Gonggao> selectListByPage(int pageNo) {
		Page<Gonggao> page = new Page<Gonggao>(pageNo, 10, "id");
		//是否为升序 ASC（ 默认： true ）
		page.setAsc(true);
		page.setRecords(baseMapper.selectPage(page, null));
		return page;
	}

	@Override
	public Gonggao getNewGonggao() {
		// TODO Auto-generated method stub
		return gonggaoMapper.getNewGonggao();
	}

}
