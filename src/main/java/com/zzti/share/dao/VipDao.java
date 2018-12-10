package com.zzti.share.dao;

import com.zzti.share.entity.Vip;

public interface VipDao {

	public int addVip(Vip vip);
	
	public Vip getVipByUser(int userId);
}
