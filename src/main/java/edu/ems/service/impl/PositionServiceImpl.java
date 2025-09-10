package edu.ems.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.ems.entity.Position;
import edu.ems.mapper.PositionMapper;
import edu.ems.service.PositionService;
//229970615 李松蔓
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
	implements PositionService{

	@Override
	public Position selectByNumber(Integer positionNumber) {
		return baseMapper.selectByNumber(positionNumber);
	}

	@Override
	public Page<Position> selectListByPage(int pageNo) {
		Page<Position> page = new Page<Position>(pageNo, 10, "id");
		page.setAsc(true);
		page.setRecords(baseMapper.selectPage(page, null));
		return page;
	}

}
