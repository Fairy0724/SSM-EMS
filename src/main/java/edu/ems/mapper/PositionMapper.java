package edu.ems.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import edu.ems.entity.Position;

//229970615 李松蔓
public interface PositionMapper extends BaseMapper<Position>{

	/**
	 * 根据PositionNumber查询信息
	 * @param positionNumber
	 * @return
	 */
	Position selectByNumber(Integer positionNumber);
}
