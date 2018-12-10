package com.zzti.share.service;

import java.util.ArrayList;

import com.zzti.share.dto.RechargeInfo;
import com.zzti.share.dto.SubjectCheck;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.entity.Admin;
import com.zzti.share.entity.Recharge;
import com.zzti.share.entity.Sub_check;

public interface AdminService {

	public Admin login(String phone, String password);
	
	public Admin getAdmin(int id);
		
	public int updatePassword(String phone, String password);
	
	public int updateInfo(String phone, String username);
	
	public ArrayList<SubjectInfo> getNoCheckSubject();
	
	public ArrayList<SubjectCheck> selectSub_check(int subject_id);
	
	public int checkSubject(int subject_id, int admin_id);
	
	public ArrayList<RechargeInfo> getNoRecharge();
	
	public int checkRecharge(int recharge_id, int admin_id ,int check);
	
	public Recharge getRechargeById(int recharge_id);
	
	public ArrayList<SubjectInfo> getNoSubjectByName(String name);

}
