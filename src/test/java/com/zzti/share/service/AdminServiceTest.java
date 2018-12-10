package com.zzti.share.service;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzti.share.BaseTest;
import com.zzti.share.dto.RechargeInfo;
import com.zzti.share.entity.Admin;
import com.zzti.share.entity.Recharge;
import com.zzti.share.entity.Sub_check;
import com.zzti.share.entity.Subject;

public class AdminServiceTest extends BaseTest{

	@Autowired
	private AdminService adminService;
	
	@Test
	public void loginTest() throws Exception {
		String phone = "13007650017";
		String password = "000000";
		Admin admin = adminService.login(phone, password);
		System.out.println("欢迎" + admin.getUsername() + "登录系统");
	}
	
	@Test
	public void updatePasswordTest() throws Exception {
		String phone = "13007650017";
		String password = "111111";
		int i = adminService.updatePassword(phone, password);
		System.out.println("输出结果：" + i);
	}
	
	
	
	@Test
	public void checkSubjectTest() throws Exception {
		int subject_id = 1;
		int admin_id = 1;
		int i = adminService.checkSubject(subject_id, admin_id);
		System.out.println("输出结果：" + i);
	}
	
	@Test
	public void getNoRechargeTest() throws Exception {
		
		ArrayList<RechargeInfo> rechargeInfoList = adminService.getNoRecharge();
		for (int i = 0; i < rechargeInfoList.size(); i++) {
			System.out.println(rechargeInfoList.get(i));
		}
	}
}
	
