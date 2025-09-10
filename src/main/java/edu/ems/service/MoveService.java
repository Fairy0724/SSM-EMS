package edu.ems.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import edu.ems.entity.Move;
//229970615 李松蔓
public interface MoveService extends IService<Move>{

	/**
	 * 查询所有的调动记录
	 * @return
	 */
	List<Move> selectList();
}
