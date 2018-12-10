package com.zzti.share.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzti.share.dao.AdminDao;
import com.zzti.share.dao.RechargeDao;
import com.zzti.share.dao.Sub_checkDao;
import com.zzti.share.dao.SubjectDao;
import com.zzti.share.dto.RechargeInfo;
import com.zzti.share.dto.SubjectCheck;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.entity.Admin;
import com.zzti.share.entity.Recharge;
import com.zzti.share.entity.Sub_check;
import com.zzti.share.entity.Subject;
import com.zzti.share.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private Sub_checkDao sub_checkDao;
	
	@Autowired
	private RechargeDao rechargeDao;
	
	@Override
	public Admin login(String phone, String password) {
		return adminDao.check(phone, password);
	}

	@Override
	public int updatePassword(String phone, String password) {
		return adminDao.updatePassword(phone, password);
	}

	@Override
	public ArrayList<SubjectInfo> getNoCheckSubject() {
		return subjectDao.getNoCheck();
	}

	@Override
	public ArrayList<SubjectCheck> selectSub_check(int subject_id) {
		return sub_checkDao.getSubBySubject(subject_id);
	}

	@Override
	public int checkSubject(int subject_id, int admin_id) {
		return subjectDao.updateCheck(subject_id, admin_id);
	}

	@Override
	public ArrayList<RechargeInfo> getNoRecharge() {
		return rechargeDao.getNoCheck();
	}

	@Override
	public int checkRecharge(int recharge_id, int admin_id, int check) {
		return rechargeDao.updateCheck(recharge_id, admin_id, check, new Date());
	}

	@Override
	public int updateInfo(String phone, String username) {
		return adminDao.updateInfo(phone, username);
	}

	@Override
	public Admin getAdmin(int id) {
		return adminDao.getAdminById(id);
	}

	@Override
	public Recharge getRechargeById(int recharge_id) {
		return rechargeDao.getRechargeById(recharge_id);
	}

	@Override
	public ArrayList<SubjectInfo> getNoSubjectByName(String name) {
		return subjectDao.getNoCheckByName(name);
	}

}
