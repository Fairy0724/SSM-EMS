package edu.ems.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import edu.ems.entity.Attendance;

//229970615 李松蔓
public interface AttendanceMapper extends BaseMapper<Attendance>{

	/**
	 * 根据employeeNumber和day查询记录
	 * @param employeeNumber
	 * @return
	 */
	Attendance selectByNumber(@Param("employeeNumber")Integer employeeNumber, 
			@Param("day")Date day, @Param("timeType")String timeType);
}
