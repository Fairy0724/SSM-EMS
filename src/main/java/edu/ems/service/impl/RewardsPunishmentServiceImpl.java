package edu.ems.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.ems.entity.RewardsPunishment;
import edu.ems.mapper.RewardsPunishmentMapper;
import edu.ems.service.RewardsPunishmentService;
//229970615 李松蔓
@Service("rewardsPunishmentService")
public class RewardsPunishmentServiceImpl extends ServiceImpl<RewardsPunishmentMapper, RewardsPunishment>
	implements RewardsPunishmentService{
	@Override//分页的
	public Page<RewardsPunishment> selectListByPage(int pageNo) {
		Page<RewardsPunishment> page = new Page<RewardsPunishment>(pageNo, 10, "id");
		//是否为升序 ASC（ 默认： true ）
		page.setAsc(true);
		page.setRecords(baseMapper.selectPage(page, null));
		return page;
	}
}
