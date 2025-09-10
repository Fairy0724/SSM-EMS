package edu.ems.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import edu.ems.entity.RewardsPunishment;
//229970615 李松蔓
public interface RewardsPunishmentService extends IService<RewardsPunishment>{
    Page<RewardsPunishment> selectListByPage(int pageNo);
}
