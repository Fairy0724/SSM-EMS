package edu.ems.mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import edu.ems.entity.Gonggao;

//229970615 李松蔓
public interface GonggaoMapper extends BaseMapper<Gonggao>{

	@Select("select * from gonggao where id = (select max(id) id from gonggao)")
	Gonggao getNewGonggao();

}
