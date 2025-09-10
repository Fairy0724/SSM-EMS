package edu.ems.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import edu.ems.entity.Position;
//229970615 李松蔓
public interface PositionService extends IService<Position>{

	/**
	 * 根据PositionNumber查询信息
	 * @param positionNumber
	 * @return
	 */
	Position selectByNumber(Integer positionNumber);
	
	/**
	 * 分页查询所有岗位（倒序）
	 * @param pageNo
	 * @return
	 */
	Page<Position> selectListByPage(int pageNo);
}
