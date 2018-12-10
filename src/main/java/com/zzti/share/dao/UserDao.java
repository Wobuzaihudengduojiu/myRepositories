package com.zzti.share.dao;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.dto.UserInfo;
import com.zzti.share.entity.User;

public interface UserDao {

	public int addUser(User user);
	
	public User check(@Param("phone") String phone,@Param("password") String password);
	
	public User getUserByPhone(String phone);
	
	public User getUserById(int id);

	public int updatePassword(@Param("phone") String phone,@Param("password") String password);
	
	public int updateGold(@Param("id") int id,@Param("gold") int gold);
	
	public int updateInfo(User user);
	
	public UserInfo getUserInfo(int id);

}
