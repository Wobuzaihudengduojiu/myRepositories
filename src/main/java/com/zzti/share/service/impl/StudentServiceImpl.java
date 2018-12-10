package com.zzti.share.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzti.share.dao.Gold_logDao;
import com.zzti.share.dao.PromotionDao;
import com.zzti.share.dao.RechargeDao;
import com.zzti.share.dao.UserDao;
import com.zzti.share.entity.User;
import com.zzti.share.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RechargeDao rechargeDao;
	
	@Autowired
	private PromotionDao promotionDao;
	
	@Autowired
	private Gold_logDao gold_logDao;
	

	@Override
	public int selectPaper(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int exam() {
		// TODO Auto-generated method stub
		return 0;
	}

}
