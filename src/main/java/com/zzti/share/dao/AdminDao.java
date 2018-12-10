package com.zzti.share.dao;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.entity.Admin;

public interface AdminDao {

	public Admin check(@Param("phone") String phone,@Param("password") String password);
	
	public Admin getAdminById(int id);
	
	public int updatePassword(@Param("phone") String phone,@Param("password") String password);
	
	public int updateInfo(@Param("phone") String phone,@Param("username") String username);
}
