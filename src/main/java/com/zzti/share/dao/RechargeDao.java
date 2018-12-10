package com.zzti.share.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.dto.RechargeInfo;
import com.zzti.share.entity.Recharge;

public interface RechargeDao {

	public int addRecharge(@Param("userId") int userId, @Param("sum") int sum, @Param("time") Date time);
	
	public ArrayList<RechargeInfo> getNoCheck();
	
	public int updateCheck(@Param("id") int id,@Param("check") int check,
			@Param("adminId")int adminId,@Param("checkTime") Date checkTime);
	
	public Recharge	getRechargeById(int id);
}
