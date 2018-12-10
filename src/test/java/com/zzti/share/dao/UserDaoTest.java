//package com.zzti.share.dao;
//
//import java.util.Date;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.zzti.share.BaseTest;
//import com.zzti.share.entity.User;
//
//public class UserDaoTest extends BaseTest {
//	@Autowired
//	private UserDao userDao;
//
//	@Test
//	public void testAddUser() throws Exception {
//		User user = new User();
//		user.setUsername("刘");
//		user.setPhone("15517140555");
//		user.setPassword("111111");
//		user.setSchool_id(1);
//		user.setProfession_id(1);
//		user.setGold(0);
//		user.setIdentity(0);
//		user.setIp("1.1.1.2");
//		user.setTime(new Date());
//		int i = userDao.addUser(user);
//		System.out.println("添加用户：" + i);
//	}
//	
//	@Test
//	public void testcheck() throws Exception {
//		String phone = "";
//		String password = "";
//		User user = new User();
//		user = userDao.check(phone, password);
//		System.out.println("用户：" + user);
//	}
//	
//
//}
