package com.zzti.share.service;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzti.share.BaseTest;
import com.zzti.share.dto.PaperInfo;
import com.zzti.share.entity.Profession;
import com.zzti.share.entity.School;
import com.zzti.share.entity.User;

public class CommonServiceTest extends BaseTest{

	@Autowired
	private CommonService commonService;

	@Test
	public void loginTest() throws Exception {
		String phone = "13000000001";
		String password = "000000";
		User user = commonService.login(phone, password);
		System.out.println("欢迎" + user.getUsername() + "登录系统");
	}
	
	@Test
	public void registerTest() throws Exception {
		
	}
	
	@Test
	public void updatePasswordTest() throws Exception {
		String phone = "13000000001";
		String password = "000000";
		int i = commonService.updatePassword(phone, password);
		System.out.println("输出结果：" + i);
	}
	
	@Test
	public void rechargeTest() throws Exception {
		int user_id = 3;
		String gold = "100金币";
		int count = 2;
		int i = commonService.recharge(user_id, gold, count);
		System.out.println("输出结果：" + i);
	}
	
	@Test
	public void promotionTest() throws Exception {
		int user_id = 3;		
		int i = commonService.promotion(user_id);
		System.out.println("输出结果：" + i);
	}
	
	@Test
	public void getSchoolTest() throws Exception {
		ArrayList<School> list = commonService.getSchool();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void getProfessionTest() throws Exception {
		ArrayList<Profession> list = commonService.getProfession();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void getPaperByUserTest() throws Exception {
		ArrayList<PaperInfo> list = commonService.getAllPaperByUser(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
